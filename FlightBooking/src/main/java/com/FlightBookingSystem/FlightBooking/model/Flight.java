package com.FlightBookingSystem.FlightBooking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@Table(name = "flights_record")
public class Flight {
    @Id

    private BigInteger flightNo;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter Carrier Name!")
    private String carrierName;
    @Size(min = 2, max = 20)

    @NotNull(message = "Pls Enter Flight Model!")
    private String flightModel;

    @NotNull(message = "Pls Enter Seat Capacity")
    private Integer seatCapacity;




    public Flight(BigInteger flightNo, String carrierName, String flightModel,Integer seatCapacity) {
        this.flightNo = flightNo;
        this.carrierName = carrierName;
        this.flightModel = flightModel;
        this.seatCapacity = seatCapacity;
    }
}
