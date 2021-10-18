package com.FlightBookingSystem.FlightBooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FlightBookingSystem.FlightBooking.model.Airports;



    @Repository
    public interface AirportRepository extends CrudRepository<Airports, String> {

    }


