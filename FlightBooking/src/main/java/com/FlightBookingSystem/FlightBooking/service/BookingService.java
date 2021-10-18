package com.FlightBookingSystem.FlightBooking.service;
import java.math.BigInteger;

import com.FlightBookingSystem.FlightBooking.model.Booking;
import org.springframework.http.ResponseEntity;



public interface BookingService {

    public ResponseEntity<?> createBooking(Booking newBooking);

    public Booking updateBooking(Booking newBooking);

    public String deleteBooking(BigInteger bookingId);

    public Iterable<Booking> displayAllBooking();

    public ResponseEntity<?> findBookingById(BigInteger bookingId);
}

