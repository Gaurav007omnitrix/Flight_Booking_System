package com.FlightBookingSystem.FlightBooking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "airports_record")
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String airportCode;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter Airport Name!")
    private String airportName;
    @Size(min = 2, max = 20)

    @NotNull(message = "Pls Enter Airport Location!")
    private String airportLocation;


    public Airports(String airportName, String airportLocation, String airportCode) {
        this.airportName = airportName;
        this.airportLocation = airportLocation;
        this.airportCode = airportCode;
    }
}
