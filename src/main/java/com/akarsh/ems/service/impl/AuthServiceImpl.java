package com.akarsh.ems.service.impl;

import com.akarsh.ems.dto.LoginRequest;
import com.akarsh.ems.entity.User;
import com.akarsh.ems.repository.UserRepository;
import com.akarsh.ems.security.JwtUtil;
import com.akarsh.ems.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.akarsh.ems.response.ApiResponse;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().getName().name()
        );

    }
}
