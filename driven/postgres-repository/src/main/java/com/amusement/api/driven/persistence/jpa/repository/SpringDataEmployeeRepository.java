package com.amusement.api.driven.persistence.jpa.repository;

import com.amusement.api.driven.persistence.jpa.entity.EmployeeEntity;
import com.amusement.api.driven.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}