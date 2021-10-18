package com.FlightBookingSystem.FlightBooking.exception;

public class RecordAlreadyExistException extends RuntimeException {
    public RecordAlreadyExistException(String s) {
        super(s);
    }
}
