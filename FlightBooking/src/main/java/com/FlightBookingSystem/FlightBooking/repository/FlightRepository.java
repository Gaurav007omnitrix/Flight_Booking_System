package com.FlightBookingSystem.FlightBooking.repository;

import java.math.BigInteger;

import com.FlightBookingSystem.FlightBooking.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight,BigInteger>{

}
