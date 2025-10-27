package com.amusement.api.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Este es el Modelo de Dominio (POJO).
 * Representa la lógica de negocio pura, SIN anotaciones de BBDD (@Entity)
 * ni de API (@JsonProperty).
 */
@Data
public class Attraction {
    Long id;
    String name;
    Integer minHeight;
    Integer maxHeight;
    Integer length;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}