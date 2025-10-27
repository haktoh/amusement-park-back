package com.amusement.api.domain.model;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Este es el Modelo de Dominio (POJO).
 * Representa la lógica de negocio pura, SIN anotaciones de BBDD (@Entity)
 * ni de API (@JsonProperty).
 */
@Data
public class User {
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private LocalDateTime emailVerifiedAt;
}