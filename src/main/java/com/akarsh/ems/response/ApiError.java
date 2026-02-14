package com.akarsh.ems.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private boolean error;
    private String message;
}
