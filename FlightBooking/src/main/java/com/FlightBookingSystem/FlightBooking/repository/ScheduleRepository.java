package com.FlightBookingSystem.FlightBooking.repository;

import java.math.BigInteger;

import com.FlightBookingSystem.FlightBooking.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, BigInteger> {

}
