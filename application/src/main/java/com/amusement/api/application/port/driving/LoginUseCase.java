package com.amusement.api.application.port.driving;

import org.springframework.security.core.Authentication;

public interface LoginUseCase {

    /**
     * Autentica a un usuario basado en su email y contraseña.
     * @param email El email del usuario.
     * @param password La contraseña en texto plano.
     * @return un objeto Authentication si tiene éxito.
     * @throws org.springframework.security.core.AuthenticationException si falla.
     */
    Authentication login(String email, String password);
}