package com.FlightBookingSystem.FlightBooking.service;

import com.FlightBookingSystem.FlightBooking.model.Airports;
import org.springframework.http.ResponseEntity;


public interface AirportService {
    public Iterable<Airports> viewAllAirport();

    public Airports viewAirport(String airportCode);

    public ResponseEntity<?> addAirport(Airports airport);

    public Airports modifyAirport(Airports airport);

    public String removeAirport(String airportCode);
}