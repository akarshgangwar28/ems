package com.akarsh.ems.dto;

import com.akarsh.ems.entity.RoleType;
import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String password;

    private String firstName;
    private String lastName;

    private RoleType role;
    private Long departmentId;
}
