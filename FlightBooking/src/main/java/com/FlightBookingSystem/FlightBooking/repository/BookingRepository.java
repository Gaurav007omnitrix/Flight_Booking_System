package com.FlightBookingSystem.FlightBooking.repository;

import java.math.BigInteger;
import com.FlightBookingSystem.FlightBooking.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, BigInteger> {

}
