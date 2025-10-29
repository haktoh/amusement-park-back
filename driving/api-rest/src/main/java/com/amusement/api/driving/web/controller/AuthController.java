package com.amusement.api.driving.web.controller;

import com.amusement.api.driving.web.dto.LoginRequest;
import com.amusement.api.driving.web.dto.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        // --- POR AHORA, LO DEJAMOS ASÍ ---
        // (Más adelante, llamaremos al caso de uso aquí)
        // String token = loginUseCase.login(request.getEmail(), request.getPassword());

        // Simulamos una respuesta para que compile
        String token = "esto-es-un-token-de-prueba-que-cambiaremos";

        return ResponseEntity.ok(new LoginResponse(token));
    }
}