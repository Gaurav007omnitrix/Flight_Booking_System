package com.FlightBookingSystem.FlightBooking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@Table(name = "booking_record")
public class Booking {
        @Id

        private BigInteger bookingId;
        private String bookingDate;
        private int noOfPassengers;

        public Booking(BigInteger bookingId,String bookingDate,Integer noOfPassengers) {
            this.bookingId=bookingId;
            this.bookingDate=bookingDate;
            this.noOfPassengers=noOfPassengers;
        }

    }
