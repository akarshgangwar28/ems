package com.akarsh.ems.controller;

import com.akarsh.ems.entity.LeaveRequest;
import com.akarsh.ems.entity.User;
import com.akarsh.ems.response.ApiResponse;
import com.akarsh.ems.service.LeaveReqService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/leave")
@RequiredArgsConstructor
public class LeaveRequestController {
    private final LeaveReqService leaveRequestService;

    @GetMapping("/user/{id}")
    public ApiResponse<List<LeaveRequest>> getLeavesByUserId(
            @PathVariable Long id
    ) {

        return ApiResponse.success(
                "Leaves fetched",
                leaveRequestService.getLeavesByUserId(id)
        );
    }

    @GetMapping
    public ApiResponse<List<LeaveRequest>> myLeaves() {
        return ApiResponse.success(
                "My leaves",
                leaveRequestService.getMyLeaves()
        );
    }

}
