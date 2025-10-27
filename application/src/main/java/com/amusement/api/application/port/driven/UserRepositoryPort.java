package com.amusement.api.application.port.driven;

import com.amusement.api.domain.model.User;

import java.util.Optional;
// Este es el contrato que el Repositorio de Postgres implementará.
// Define "qué" necesita la aplicación del exterior.
public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(String email);
}
