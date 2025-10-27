package com.amusement.api.application.port.driving;

import com.amusement.api.domain.model.User;

// Este es el contrato que el Controlador REST usará.
// Define "qué" puede hacer la aplicación.
public interface CreateUserUseCase {
    User createUser(User user);
}