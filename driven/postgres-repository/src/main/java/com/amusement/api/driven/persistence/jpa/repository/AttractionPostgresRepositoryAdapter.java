package com.amusement.api.driven.persistence.jpa.repository;

import com.amusement.api.application.port.driven.AttractionsRepositoryPort;
import com.amusement.api.domain.model.Attraction;
import com.amusement.api.driven.persistence.jpa.entity.AttractionEntity;
import com.amusement.api.driven.persistence.jpa.mapper.AttractionPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AttractionPostgresRepositoryAdapter implements AttractionsRepositoryPort {
    private final SpringDataAttractionRepository jpaRepository;

    private final AttractionPersistenceMapper mapper;

    @Override
    public List<Attraction> findAll() {
        List<AttractionEntity> entities = jpaRepository.findAll();
        return mapper.toDomain(entities);
    }

    @Override
    public Attraction findById(Long id) {
        AttractionEntity entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Attraction not found"));
        return mapper.toDomain(entity);

    }
}