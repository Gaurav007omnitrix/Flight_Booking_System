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
@Table(name = "users_record")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger userId;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter User Name!")
    private String userName;
    @Size(min = 2, max = 20)

    @NotNull(message = "Pls Enter Password!")
    private String userPassword;

    @NotNull(message = "Pls Enter phoneNo")
    private Integer userPhone;

    @NotNull(message = "Pls Enter Email")
    private String userEmail;

    @NotNull(message = "Pls Enter User Type")
    private String userType;


    public Users(String userName, String userPassword, Integer userPhone, String userEmail, String userType, BigInteger userId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userType = userType;
        this.userId = userId;
    }
}
