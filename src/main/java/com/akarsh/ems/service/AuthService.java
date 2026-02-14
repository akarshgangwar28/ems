package com.akarsh.ems.service;

import com.akarsh.ems.dto.LoginRequest;

public interface AuthService {
    String login(LoginRequest request);
}
