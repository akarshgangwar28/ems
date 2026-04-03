package com.akarsh.ems.controller;

import com.akarsh.ems.entity.Department;
import com.akarsh.ems.response.ApiResponse;
import com.akarsh.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor

public class DepartmentController {

    private final DepartmentService deptService;

    @GetMapping("/all")
    public ApiResponse<List<Department>> getDept(){
        return ApiResponse.success(
                 "Found",
                deptService.getAll()
        );
    }

    @PostMapping("/create")
    public ApiResponse<Void> createDept(){

//        deptService.create(...);

        return ApiResponse.success("Created", null);
    }

}
