package com.amusement.api.application.service;

import com.amusement.api.application.port.driven.UserRepositoryPort;
import com.amusement.api.application.port.driving.CreateUserUseCase;
import com.amusement.api.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user, String plainPassword) {
        if (userRepositoryPort.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("El email " + user.getEmail() + " ya está en uso.");
        }
        String hashedPassword = passwordEncoder.encode(plainPassword);
        return userRepositoryPort.save(user, hashedPassword);
    }
}
