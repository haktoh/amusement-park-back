package com.amusement.api.driven.persistence.jpa.repository;

import com.amusement.api.driven.persistence.jpa.entity.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAttractionRepository extends JpaRepository<AttractionEntity, Long> {
}