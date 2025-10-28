package com.amusement.api.driving.web.controller;

import com.amusement.api.application.port.driving.GetAttractionsUseCase;
import com.amusement.api.application.port.driving.GetEmployeesUseCase;
import com.amusement.api.domain.model.Attraction;
import com.amusement.api.domain.model.Employee;
import com.amusement.api.driving.web.dto.AttractionResponse;
import com.amusement.api.driving.web.dto.EmployeeResponse;
import com.amusement.api.driving.web.mapper.AttractionApiMapper;
import com.amusement.api.driving.web.mapper.EmployeeApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeApiMapper attractionApiMapper;
    private final GetEmployeesUseCase getEmployeesUseCase;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<Employee> employees = getEmployeesUseCase.getEmployees();
        List<EmployeeResponse> response = attractionApiMapper.toResponseList(employees);
        return ResponseEntity.ok(response);
    }
}