package com.akarsh.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProfileResponse {

    private String email;
    private String firstName;
    private String lastName;
    private String role;

    private String department;

    private String ctc;
    private String inHandSalary;
    private Date dateOfJoining;
    private String phone;
    private String status;
    private String address;

}
