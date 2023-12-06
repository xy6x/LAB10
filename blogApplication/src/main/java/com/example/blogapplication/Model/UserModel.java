package com.example.blogapplication.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class UserModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "please enter userName")
    @Column(columnDefinition = "varchar(50)not null unique")
    private String userName;
    @Email
    @NotEmpty(message = "please enter Email")
    @Column(columnDefinition = "varchar(50)not null unique")
    private String email;
    @NotEmpty(message = "please enter Password")
    @Column(columnDefinition = "varchar(50)not null")
    private String password;
    private LocalDate registration_date=LocalDate.now();


}
