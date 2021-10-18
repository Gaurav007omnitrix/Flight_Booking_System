package com.FlightBookingSystem.FlightBooking.service;

import java.math.BigInteger;

import  com.FlightBookingSystem.FlightBooking.model.Flight;
import org.springframework.http.ResponseEntity;


public interface FlightService {
    public ResponseEntity<?> addFlight(Flight flight);

    public Iterable<Flight> viewAllFlight();

    public Flight viewFlight(BigInteger flightNumber);

    public Flight modifyFlight(Flight flight);

    public String removeFlight(BigInteger flightNumber);

}
