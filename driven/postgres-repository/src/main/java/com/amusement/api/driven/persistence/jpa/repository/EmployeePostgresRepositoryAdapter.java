package com.amusement.api.driven.persistence.jpa.repository;

import com.amusement.api.application.port.driven.AttractionsRepositoryPort;
import com.amusement.api.application.port.driven.EmployeeRepositoryPort;
import com.amusement.api.domain.model.Attraction;
import com.amusement.api.domain.model.Employee;
import com.amusement.api.driven.persistence.jpa.entity.AttractionEntity;
import com.amusement.api.driven.persistence.jpa.entity.EmployeeEntity;
import com.amusement.api.driven.persistence.jpa.mapper.AttractionPersistenceMapper;
import com.amusement.api.driven.persistence.jpa.mapper.EmployeePersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeePostgresRepositoryAdapter implements EmployeeRepositoryPort {
    private final SpringDataEmployeeRepository jpaRepository;

    private final EmployeePersistenceMapper mapper;

    @Override
    public List<Employee> findAll() {
        List<EmployeeEntity> entities = jpaRepository.findAll();
        return mapper.toDomain(entities);
    }
}