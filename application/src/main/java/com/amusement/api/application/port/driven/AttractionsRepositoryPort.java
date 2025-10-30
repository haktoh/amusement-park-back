package com.amusement.api.application.port.driven;

import com.amusement.api.domain.model.Attraction;

import java.util.List;

// Este es el contrato que el Repositorio de Postgres implementará.
// Define "qué" necesita la aplicación del exterior.
public interface AttractionsRepositoryPort {
    List<Attraction> findAll();
    Attraction findById(Long id);
    void deleteById(Long id);
}
