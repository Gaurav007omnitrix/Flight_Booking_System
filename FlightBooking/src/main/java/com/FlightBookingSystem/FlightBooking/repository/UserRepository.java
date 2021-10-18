package com.FlightBookingSystem.FlightBooking.repository;

import java.math.BigInteger;

import com.FlightBookingSystem.FlightBooking.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, BigInteger> {

}