package com.FlightBookingSystem.FlightBooking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
@Data
@NoArgsConstructor
@Entity
@Table(name="passenger_record")
public class Passenger {
    @Id

    private BigInteger pnrNumber;
    private String passengerName;
    private int passengerAge;
    private BigInteger passengerUIN;
    private Double luggage;

    public Passenger(BigInteger pnrNumber,String passengerName,Integer passengerAge,BigInteger passengerUIN,Double luggage) {
        this.pnrNumber=pnrNumber;
        this.passengerName=passengerName;
        this.passengerAge=passengerAge;
        this.passengerUIN=passengerUIN;
        this.luggage=luggage;

    }
}
