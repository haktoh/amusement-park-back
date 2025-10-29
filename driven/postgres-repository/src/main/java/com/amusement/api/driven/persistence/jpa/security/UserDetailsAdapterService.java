package com.amusement.api.driven.persistence.jpa.security;

import com.amusement.api.driven.persistence.jpa.entity.UserEntity;
import com.amusement.api.driven.persistence.jpa.repository.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections; // Importa esto

@Service // Es un bean de Spring
@RequiredArgsConstructor
public class UserDetailsAdapterService implements UserDetailsService {

    // 1. Inyectamos el repositorio JPA (nuestra herramienta de infraestructura)
    private final SpringDataUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 2. Spring Security nos llama con el "username" (que para nosotros es el email)
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario no encontrado con email: " + email)
                );

        // 3. Creamos y devolvemos el objeto "User" que Spring Security entiende
        //    (con el email, el HASH de la contraseña y una lista vacía de roles por ahora)
        return new User(userEntity.getEmail(), userEntity.getPassword(), Collections.emptyList());
    }
}