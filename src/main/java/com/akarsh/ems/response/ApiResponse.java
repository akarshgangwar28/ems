package com.akarsh.ems.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private Boolean error;
    private String message;
    private T data;

    // success response
    public static <T> ApiResponse<T> success(String message, T data) {
        ApiResponse<T> res = new ApiResponse<>();
        res.message = message;
        res.data = data;
        return res;
    }

    // error response
    public static <T> ApiResponse<T> error(String message) {
        ApiResponse<T> res = new ApiResponse<>();
        res.error = true;
        res.message = message;
        return res;
    }
}
