package com.amusement.api.driving.web.mapper;

import com.amusement.api.domain.model.Attraction;
import com.amusement.api.domain.model.Employee;
import com.amusement.api.driving.web.dto.AttractionResponse;
import com.amusement.api.driving.web.dto.EmployeeResponse;
import org.mapstruct.Mapper;

import java.util.List;

// Le decimos a MapStruct que genere un Bean de Spring
@Mapper(componentModel = "spring")
public interface EmployeeApiMapper {
    EmployeeResponse toResponse(Employee employee);
    List<EmployeeResponse> toResponseList(List<Employee> employees);
}