package com.amusement.api.driven.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity // 1. Le dice a JPA que esto es una entidad
@Table(name = "users") // 2. Le dice con qué tabla se mapea
public class UserEntity {

    @Id // 3. Marca la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Le dice que es autoincremental (BIGSERIAL)
    private Long id;

    private String dni;
    private String name;
    private String surname;
    private Integer age;
    private String email;

    // 5. Mapea el nombre de la columna de snake_case (BBDD) a camelCase (Java)
    @Column(name = "email_verified_at")
    private LocalDateTime emailVerifiedAt;

    private String password;

    // Dejamos fuera 'remember_token', 'created_at', etc. por ahora,
    // JPA puede gestionarlos automáticamente si quisiéramos.
}