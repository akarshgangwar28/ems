package com.akarsh.ems.repository;

import com.akarsh.ems.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    // get all leave requests for a specific user
    List<LeaveRequest> findByUserId(Long userId);

    // get leave requests by status
    List<LeaveRequest> findByStatus(String status);

    // get leave requests for user + status
    List<LeaveRequest> findByUserIdAndStatus(Long userId, String status);
}