package com.FlightBookingSystem.FlightBooking.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.FlightBookingSystem.FlightBooking.exception.RecordNotFoundException;
import com.FlightBookingSystem.FlightBooking.exception.ScheduledFlightNotFoundException;
import com.FlightBookingSystem.FlightBooking.model.Schedule;
import com.FlightBookingSystem.FlightBooking.model.ScheduledFlight;
import com.FlightBookingSystem.FlightBooking.repository.ScheduleRepository;
import com.FlightBookingSystem.FlightBooking.repository.ScheduledFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

    @Autowired
    ScheduledFlightRepository dao;

    @Autowired
    ScheduleRepository scheduleDao;

    @Autowired
    BookingService bookingService;


    @Override
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
        return dao.save(scheduledFlight);
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduleFlight) {
        ScheduledFlight updateScheduleFlight = dao.findById(scheduleFlight.getScheduleFlightId()).get();
        Schedule updateSchedule = scheduleDao.findById(scheduleFlight.getSchedule().getScheduleId()).get();
        updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
        updateSchedule.setSrcAirport(scheduleFlight.getSchedule().getSrcAirport());
        updateSchedule.setDstnAirport(scheduleFlight.getSchedule().getDstnAirport());
        updateSchedule.setArrDateTime(scheduleFlight.getSchedule().getArrDateTime());
        updateSchedule.setDeptDateTime(scheduleFlight.getSchedule().getDeptDateTime());
        dao.save(updateScheduleFlight);
        return scheduleFlight;
    }


    @Override
    public String removeScheduledFlight(BigInteger flightId) throws RecordNotFoundException {
        if (flightId == null)
            throw new RecordNotFoundException("Enter flight Id");
        Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
        if (!scheduleFlight.isPresent())
            throw new RecordNotFoundException("Enter a valid Flight Id");
        else {
            // try {
            // cancelBookings(flightId);
            // } catch (RecordNotFoundException e) {
            // System.out.println("No Bookings Found");
            // }
            dao.deleteById(flightId);
        }
        return "Scheduled flight with ID " + flightId + " is not found";
    }

    // @Override
    // public boolean cancelBookings(BigInteger flightId) throws
    // RecordNotFoundException {
    // Iterable<Booking> bookingList = bookingService.displayAllBooking();
    // for (Booking booking : bookingList) {
    // if (booking.getScheduleFlight().getScheduleFlightId().equals(flightId)) {
    // bookingService.deleteBooking(booking.getBookingId());
    // }
    // }
    // return true;
    // }


    @Override
    public Iterable<ScheduledFlight> viewAllScheduledFlights() {
        return dao.findAll();
    }


    @Override
    public ScheduledFlight viewScheduledFlight(BigInteger flightId) throws ScheduledFlightNotFoundException {
        if (flightId == null)
            throw new ScheduledFlightNotFoundException("Enter flight Id");
        Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
        if (!scheduleFlight.isPresent())
            throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
        else
            return scheduleFlight.get();
    }

}

