package com.amusement.api.driving.web.controller;

import com.amusement.api.application.port.driving.CreateUserUseCase;
import com.amusement.api.domain.model.User;
import com.amusement.api.driving.web.dto.CreateUserRequest;
import com.amusement.api.driving.web.dto.UserResponse;
import com.amusement.api.driving.web.mapper.UserApiMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. Le dice a Spring que esto es un controlador de API REST
@RequestMapping("/api/v1/users") // 2. La URL base para todos los endpoints de este controlador
@RequiredArgsConstructor // 3. Lombok para la inyección de dependencias
public class UserController {

    // --- Inyectamos nuestros contratos (Puertos) ---

    // A. Inyectamos el PUERTO DE ENTRADA (Caso de Uso) del módulo 'application'
    private final CreateUserUseCase createUserUseCase;

    // B. Inyectamos el "Traductor" que acabamos de crear
    private final UserApiMapper userApiMapper;

    @PostMapping // 4. Este método maneja peticiones POST a /api/v1/users
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {

        // 5. El flujo de trabajo del controlador:

        // A. Traduce: DTO de Petición -> Modelo de Dominio
        User userDomain = userApiMapper.toDomain(request);

        // (Aquí podríamos pasar el request.getPassword() al servicio si
        //  nuestro caso de uso se encargara de encriptarlo)

        // B. Delega: Llama al Caso de Uso (el "cerebro" en 'application')
        User createdUser = createUserUseCase.createUser(userDomain);

        // C. Traduce: Modelo de Dominio -> DTO de Respuesta
        UserResponse response = userApiMapper.toResponse(createdUser);

        // 6. Devuelve una respuesta HTTP 201 (Created) con el usuario creado
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}