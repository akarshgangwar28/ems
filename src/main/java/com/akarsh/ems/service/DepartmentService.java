package com.akarsh.ems.service;

import com.akarsh.ems.entity.Department;
import com.akarsh.ems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    // create department
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    // get all departments
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
