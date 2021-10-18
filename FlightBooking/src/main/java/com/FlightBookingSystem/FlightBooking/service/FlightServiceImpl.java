package com.FlightBookingSystem.FlightBooking.service;

import com.FlightBookingSystem.FlightBooking.exception.RecordAlreadyExistException;
import com.FlightBookingSystem.FlightBooking.exception.RecordNotFoundException;
import com.FlightBookingSystem.FlightBooking.model.Flight;
import com.FlightBookingSystem.FlightBooking.repository.FlightRepository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    /*
     * add a flight
     */
    @Override
    public ResponseEntity<Flight> addFlight(Flight flight) {
        Optional<Flight> findById = flightRepository.findById(flight.getFlightNo());
        try {
            if (!findById.isPresent()) {
                flightRepository.save(flight);
                return new ResponseEntity<Flight>(flight,HttpStatus.OK);
            } else
                throw new RecordAlreadyExistException("Flight with number: " + flight.getFlightNo() + " already present");
        }
        catch(RecordAlreadyExistException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Iterable<Flight> viewAllFlight() {
        return flightRepository.findAll();
    }


    @Override
    public Flight viewFlight(BigInteger flightNumber) {
        Optional<Flight> findById = flightRepository.findById(flightNumber);
        if (findById.isPresent()) {
            return findById.get();
        }
        else
            throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}*/


    @Override
    public Flight modifyFlight(Flight flight) {
        Optional<Flight> findById = flightRepository.findById(flight.getFlightNo());
        if (findById.isPresent()) {
            flightRepository.save(flight);
        } else
            throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
        return flight;
    }


    public String removeFlight(BigInteger flightNumber) {
        Optional<Flight> findById = flightRepository.findById(flightNumber);
        if (findById.isPresent()) {
            flightRepository.deleteById(flightNumber);
            return "Flight removed!!";
        } else
            throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

    }
}
