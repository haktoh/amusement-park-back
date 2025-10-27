package com.amusement.api.driven.persistence.jpa.repository;

import com.amusement.api.application.port.driven.UserRepositoryPort;
import com.amusement.api.domain.model.User;
import com.amusement.api.driven.persistence.jpa.entity.UserEntity;
import com.amusement.api.driven.persistence.jpa.mapper.UserPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPostgresRepositoryAdapter implements UserRepositoryPort {
    // A. El repositorio MÁGICO de Spring
    private final SpringDataUserRepository jpaRepository;

    // B. El "Traductor" de BBDD
    private final UserPersistenceMapper mapper;


    @Override // 4. Implementamos el método del puerto
    public User save(User user, String hashedPassword) {
        // 1. Traduce: Modelo de Dominio -> Entidad de BBDD
        UserEntity userEntity = mapper.toEntity(user);
        userEntity.setPassword(hashedPassword);

        // 2. Persiste: Llama al repositorio de Spring
        UserEntity savedEntity = jpaRepository.save(userEntity);

        // 3. Traduce: Entidad de BBDD -> Modelo de Dominio
        return mapper.toDomain(savedEntity);
    }

    @Override // 5. Implementamos el otro método del puerto
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }
}