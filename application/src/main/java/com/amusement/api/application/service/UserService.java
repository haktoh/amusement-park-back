package com.amusement.api.application.service;

// 1. AÑADE ESTOS IMPORTS
import com.amusement.api.application.port.driving.LoginUseCase;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.amusement.api.application.port.driven.UserRepositoryPort;
import com.amusement.api.application.port.driving.CreateUserUseCase;
import com.amusement.api.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// 2. AÑADE LA NUEVA INTERFAZ A 'implements'
public class UserService implements CreateUserUseCase, LoginUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    // 3. INYECTA EL AuthenticationManager (que creamos como Bean en SecurityConfig)
    private final AuthenticationManager authenticationManager;

    // --- (Este es tu método original, se queda igual) ---
    @Override
    public User createUser(User user, String plainPassword) {
        if (userRepositoryPort.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("El email " + user.getEmail() + " ya está en uso.");
        }
        String hashedPassword = passwordEncoder.encode(plainPassword);
        return userRepositoryPort.save(user, hashedPassword);
    }

    // 4. IMPLEMENTA EL NUEVO MÉTODO DE LOGIN
    @Override
    public Authentication login(String email, String password) {

        // Crea un "ticket" de autenticación con las credenciales planas
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(email, password);

        // El AuthenticationManager hace el trabajo:
        // - Llama a tu 'UserDetailsAdapterService' para buscar al usuario por email.
        // - Coge el HASH de la BBDD.
        // - Usa tu 'PasswordEncoder' para comparar el hash con la contraseña plana.
        // - Si coinciden, devuelve un objeto Authentication. Si no, lanza una excepción.
        return authenticationManager.authenticate(authToken);
    }
}