package com.akarsh.ems.service.impl;

import com.akarsh.ems.dto.ProfileResponse;
import com.akarsh.ems.dto.RegisterRequest;
import com.akarsh.ems.entity.*;
import com.akarsh.ems.repository.DepartmentRepository;
import com.akarsh.ems.repository.RoleRepository;
import com.akarsh.ems.repository.UserRepository;
import com.akarsh.ems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Role role = roleRepository.findByName(request.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(role)
                .department(department)
                .enabled(true)
                .build();

        userRepository.save(user);
    }


    @Override
    public ProfileResponse getMyProfile() {
        System.out.println(
                "AUTH = " + SecurityContextHolder.getContext().getAuthentication()
        );
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        System.out.println("TOKEN EMAIL = " + email);


        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println(SecurityContextHolder.getContext().getAuthentication());

        return new ProfileResponse(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole().getName().name(),
                user.getDepartment().getName()
        );
    }
}
