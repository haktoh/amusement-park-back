package com.amusement.api.application.service;

import com.amusement.api.application.port.driven.UserRepositoryPort;
import com.amusement.api.application.port.driving.CreateUserUseCase;
import com.amusement.api.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}
