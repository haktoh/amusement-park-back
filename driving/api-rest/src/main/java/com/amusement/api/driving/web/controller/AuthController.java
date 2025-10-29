package com.amusement.api.driving.web.controller;

// Importa las clases que necesitamos
import com.amusement.api.application.port.driving.LoginUseCase;
import com.amusement.api.application.service.JwtService;
import com.amusement.api.driving.web.dto.LoginRequest;
import com.amusement.api.driving.web.dto.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication; // <-- Importante
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    // 1. Inyectamos los servicios REALES (el "cerebro" y el "cerrajero")
    private final LoginUseCase loginUseCase;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        // 2. Llama al "cerebro" (UserService) para validar email y contraseña
        Authentication authentication = loginUseCase.login(
                request.getEmail(), request.getPassword()
        );

        // 3. Si la autenticación tuvo éxito, llama al "cerrajero" (JwtService)
        String token = jwtService.generateToken(authentication);

        // 4. Devuelve el token REAL
        return ResponseEntity.ok(new LoginResponse(token));
    }
}