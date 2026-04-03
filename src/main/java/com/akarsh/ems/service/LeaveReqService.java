package com.akarsh.ems.service;

import com.akarsh.ems.entity.LeaveRequest;
import com.akarsh.ems.entity.User;
import com.akarsh.ems.repository.UserRepository;
import com.akarsh.ems.repository.LeaveRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveReqService {

    private final LeaveRequestRepository leaveRepository;
    private final UserRepository userRepository;


    // apply leave
    public LeaveRequest apply(LeaveRequest leave) {
        leave.setStatus("PENDING");
        return leaveRepository.save(leave);
    }

    // get all leaves (admin)
    public List<LeaveRequest> getAll() {
        return leaveRepository.findAll();
    }

    // get leaves of specific user
    public List<LeaveRequest> getLeavesByUserId(Long userId) {
        return leaveRepository.findByUserId(userId);
    }

    public List<LeaveRequest> getMyLeaves(){

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return leaveRepository.findByUserId(user.getId());
    }
}