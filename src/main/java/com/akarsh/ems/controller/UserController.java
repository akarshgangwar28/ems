package com.akarsh.ems.controller;

import com.akarsh.ems.dto.ProfileResponse;
import com.akarsh.ems.dto.RegisterRequest;
import com.akarsh.ems.response.ApiResponse;
import com.akarsh.ems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<Void> register(@RequestBody RegisterRequest request) {
        userService.register(request);
        return ApiResponse.success("User registered successfully", null);
    }

    @GetMapping("/me")
    public ApiResponse<ProfileResponse> myProfile() {
        return ApiResponse.success(
                "Profile fetched",
                userService.getMyProfile()
        );
    }
}
