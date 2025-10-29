package com.amusement.api.driving.web.controller;

import com.amusement.api.application.port.driving.GetEmployeesUseCase;
import com.amusement.api.domain.model.Employee;
import com.amusement.api.driving.web.dto.EmployeeResponse;
import com.amusement.api.driving.web.mapper.EmployeeApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeApiMapper employeeApiMapper;
    private final GetEmployeesUseCase getEmployeesUseCase;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<Employee> employees = getEmployeesUseCase.getEmployees();
        List<EmployeeResponse> response = employeeApiMapper.toResponseList(employees);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        Employee employee = getEmployeesUseCase.getEmployeeById(id);
        var response = employeeApiMapper.toResponse(employee);
        return ResponseEntity.ok().body(response);
    }
}