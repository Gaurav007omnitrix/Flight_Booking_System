package com.FlightBookingSystem.FlightBooking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users_record")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter User Name!")
    private String username;
    @Size(min = 2, max = 20)

    @NotNull(message = "Pls Enter Password!")
    private String password;

    @NotNull(message = "Pls Enter phoneNo")
    private Integer phoneNo;

    @NotNull(message = "Pls Enter Email")
    private String email;

    @NotNull(message = "Pls Enter User Type")
    private String userType;


    public User(String username, String password,Integer phoneNo, String email, String userType,Integer id) {
        this.username = username;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
        this.userType = userType;
        this.id = id;
    }
}
