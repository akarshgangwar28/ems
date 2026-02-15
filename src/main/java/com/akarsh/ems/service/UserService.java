package com.akarsh.ems.service;

import com.akarsh.ems.dto.ProfileResponse;
import com.akarsh.ems.dto.RegisterRequest;

public interface UserService {
    void register(RegisterRequest request);

    ProfileResponse getMyProfile();

}
