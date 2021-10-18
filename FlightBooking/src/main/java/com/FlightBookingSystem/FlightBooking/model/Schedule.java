package com.FlightBookingSystem.FlightBooking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
    @Data
    @NoArgsConstructor
    @Entity
    @Table(name ="schedule_record")
    public class Schedule {
        @Id
        @Column(name = "schedule_Id")

        private BigInteger scheduleId;

        @OneToOne(fetch = FetchType.EAGER)
        private Airports srcAirport;

        @OneToOne(fetch = FetchType.EAGER)
        private Airports dstnAirport;

        @Column(name = "departure_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
        private String deptDateTime;

        @Column(name = "arrival_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
        private String arrDateTime;


        public Schedule(BigInteger scheduleId,Airports srcAirport,Airports dstnAirport,String deptDateTime, String arrDateTime) {
            this.scheduleId=scheduleId;
            this.srcAirport=srcAirport;
            this.dstnAirport=dstnAirport;
            this.deptDateTime=deptDateTime;
            this.arrDateTime=arrDateTime;
        }

}
