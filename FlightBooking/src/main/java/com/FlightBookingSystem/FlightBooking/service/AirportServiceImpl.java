package com.FlightBookingSystem.FlightBooking.service;
import com.FlightBookingSystem.FlightBooking.exception.RecordAlreadyExistException;
import com.FlightBookingSystem.FlightBooking.exception.RecordNotFoundException;
import com.FlightBookingSystem.FlightBooking.model.Airports;
import com.FlightBookingSystem.FlightBooking.repository.AirportRepository;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepository airportRepository;              /** view all Airports*/
    @Override
    public Iterable<Airports> viewAllAirport() {
        return airportRepository.findAll();
    }

    /** view airport by airportCode */
    @Override
    public Airports viewAirport(String airportCode) {
        Optional<Airports> findById = airportRepository.findById(airportCode);
        if (findById.isPresent()) {
            return findById.get();
        }

        //return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
        else
            throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");
    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

    /** add a airport  */
    @Override
    public ResponseEntity<?> addAirport(Airports airport) {
        Optional<Airports> findById = airportRepository.findById(airport.getAirportCode());
        try {
            if (!findById.isPresent()) {
                airportRepository.save(airport);
                return new ResponseEntity<Airports>(airport,HttpStatus.OK);
            }
            else
                throw new RecordAlreadyExistException(
                        "Airport with code : " + airport.getAirportCode() + " already present");
        }
        catch(RecordAlreadyExistException e)
        {
            return new ResponseEntity<Airports>(airport,HttpStatus.NOT_FOUND);
        }
    }

    /** modify an Airport */
    @Override
    public Airports modifyAirport(Airports airport) {
        Optional<Airports> findById = airportRepository.findById(airport.getAirportCode());
        if (findById.isPresent()) {
            airportRepository.save(airport);
        }
        else
            throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
        return airport;
    }

    /** remove an airport*/
    @Override
    public String removeAirport(String airportCode) {
        Optional<Airports> findById = airportRepository.findById(airportCode);
        if (findById.isPresent()) {
            airportRepository.deleteById(airportCode);
            return "Airport removed";
        } else
            throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

    }
}
