package com.FlightBookingSystem.FlightBooking.service;

import java.math.BigInteger;


import com.FlightBookingSystem.FlightBooking.exception.RecordNotFoundException;
import com.FlightBookingSystem.FlightBooking.exception.ScheduledFlightNotFoundException;
import com.FlightBookingSystem.FlightBooking.model.ScheduledFlight;


public interface ScheduledFlightService {
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

    public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;

    public Iterable<ScheduledFlight> viewAllScheduledFlights();

    public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
    // boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}

