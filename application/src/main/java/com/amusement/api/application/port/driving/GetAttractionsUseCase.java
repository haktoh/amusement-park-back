package com.amusement.api.application.port.driving;

import com.amusement.api.domain.model.Attraction;

import java.util.List;

public interface GetAttractionsUseCase {
    List<Attraction> getAttractions();
}