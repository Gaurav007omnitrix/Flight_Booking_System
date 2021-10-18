package com.FlightBookingSystem.FlightBooking.controller;

import com.FlightBookingSystem.FlightBooking.exception.RecordAlreadyExistException;
import com.FlightBookingSystem.FlightBooking.exception.RecordNotFoundException;
import com.FlightBookingSystem.FlightBooking.model.Airports;
import com.FlightBookingSystem.FlightBooking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/airport")
public class AirportController {
	@Autowired(required = true)
	AirportService airportService;

	@GetMapping("/viewAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airports viewAirport(@PathVariable("id") String airportCode) {
		return airportService.viewAirport(airportCode);
	}

	@GetMapping("/allAirport")
	public Iterable<Airports> viewAllAirport() {
		return airportService.viewAllAirport();
	}

	@PostMapping("/addAirport")
	@ExceptionHandler(RecordAlreadyExistException.class)
	public void addAirport(@RequestBody Airports airport) {
		airportService.addAirport(airport);
	}

	@PutMapping("/updateAirport")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyAirport(@RequestBody Airports airport) {
		airportService.modifyAirport(airport);
	}

	@DeleteMapping("/deleteAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeAirport(@PathVariable("id") String airportCode) {
		airportService.removeAirport(airportCode);
	}
}
