package com.amusement.api.application.service;

import com.amusement.api.application.port.driven.EmployeeRepositoryPort;
import com.amusement.api.application.port.driving.GetEmployeesUseCase;
import com.amusement.api.domain.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements GetEmployeesUseCase {
    private final EmployeeRepositoryPort employeeRepositoryPort;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepositoryPort.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepositoryPort.findById(id);
    }
}
