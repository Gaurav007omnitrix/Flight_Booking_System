package com.FlightBookingSystem.FlightBooking.controller;

import com.FlightBookingSystem.FlightBooking.exception.RecordAlreadyExistException;
import com.FlightBookingSystem.FlightBooking.exception.RecordNotFoundException;
import com.FlightBookingSystem.FlightBooking.model.Booking;
import com.FlightBookingSystem.FlightBooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@CrossOrigin("http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired(required= true)
	BookingService bookingService;

	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyExistException.class)
	public void addBooking(@RequestBody Booking newBooking) {

		bookingService.createBooking(newBooking);
	}

	@GetMapping("/readAllBooking")
	public Iterable<Booking> readAllBookings() {

		return bookingService.displayAllBooking();
	}

	@PutMapping("/updateBooking")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyBooking(@RequestBody Booking updateBooking) {

		bookingService.updateBooking(updateBooking);
	}

	@GetMapping("/searchBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") BigInteger bookingId) {

		return bookingService.findBookingById(bookingId);
	}

	@DeleteMapping("/deleteBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") BigInteger bookingId) {

		bookingService.deleteBooking(bookingId);
	}
}
