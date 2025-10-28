package com.amusement.api.driven.persistence.jpa.mapper;

import com.amusement.api.domain.model.Employee;
import com.amusement.api.driven.persistence.jpa.entity.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeePersistenceMapper {

    // Convierte el Modelo de Dominio -> Entidad de BBDD
    List<EmployeeEntity> toEntity(List<Employee> attraction);

    // Convierte la Entidad de BBDD -> Modelo de Dominio
    List<Employee> toDomain(List<EmployeeEntity> attraction);
}