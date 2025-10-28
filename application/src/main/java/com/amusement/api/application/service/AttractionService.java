package com.amusement.api.application.service;

import com.amusement.api.application.port.driven.AttractionsRepositoryPort;
import com.amusement.api.application.port.driving.GetAttractionsUseCase;
import com.amusement.api.domain.model.Attraction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttractionService implements GetAttractionsUseCase {
    private final AttractionsRepositoryPort attractionsRepositoryPort;

    @Override
    public List<Attraction> getAttractions() {
        return attractionsRepositoryPort.findAll();
    }

    @Override
    public Attraction getAttractionById(Long id) {
        return attractionsRepositoryPort.findById(id);

    }
}
