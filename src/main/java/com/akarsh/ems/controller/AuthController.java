package com.akarsh.ems.controller;

import com.akarsh.ems.dto.LoginRequest;
import com.akarsh.ems.dto.LoginResponse;
import com.akarsh.ems.response.ApiResponse;
import com.akarsh.ems.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ApiResponse.success("Login successful", new LoginResponse(token));
    }

}
