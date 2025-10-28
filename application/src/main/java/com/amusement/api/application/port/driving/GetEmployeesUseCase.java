package com.amusement.api.application.port.driving;

import com.amusement.api.domain.model.Attraction;
import com.amusement.api.domain.model.Employee;

import java.util.List;

public interface GetEmployeesUseCase {
    List<Employee> getEmployees();
}