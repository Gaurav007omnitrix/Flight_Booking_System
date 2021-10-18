package com.FlightBookingSystem.FlightBooking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Data
@NoArgsConstructor
@Entity
@Table(name="scheduledflight_record")
public class ScheduledFlight {

    @Id
    @Column(name = "schedule_flight_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger scheduleFlightId;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Flight flight;

    @Column(name = "available_seats")
    @NotNull
    private Integer availableSeats;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    public ScheduledFlight(BigInteger scheduleFlightId,Flight flight,Integer availableSeats,Schedule schedule) {
        this.scheduleFlightId=scheduleFlightId;
        this.flight=flight;
        this.availableSeats=availableSeats;
        this.schedule=schedule;
    }

}
