package com.FlightBookingSystem.FlightBooking.repository;

import java.math.BigInteger;

import com.FlightBookingSystem.FlightBooking.model.ScheduledFlight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledFlightRepository extends CrudRepository<ScheduledFlight, BigInteger>{

}
