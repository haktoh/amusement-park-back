package com.amusement.api.application.port.driven;

import com.amusement.api.domain.model.Attraction;
import com.amusement.api.domain.model.Employee;

import java.util.List;

// Este es el contrato que el Repositorio de Postgres implementará.
// Define "qué" necesita la aplicación del exterior.
public interface EmployeeRepositoryPort {
    List<Employee> findAll();
    Employee findById(Long id);
}
