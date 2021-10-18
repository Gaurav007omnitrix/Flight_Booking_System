package com.FlightBookingSystem.FlightBooking.exception;

public class ScheduledFlightNotFoundException extends RuntimeException {
    public ScheduledFlightNotFoundException(String s) {
        super(s);
    }
}
