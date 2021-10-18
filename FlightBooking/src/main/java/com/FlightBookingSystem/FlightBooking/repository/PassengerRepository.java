package com.FlightBookingSystem.FlightBooking.repository;

import com.FlightBookingSystem.FlightBooking.model.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, BigInteger> {

}