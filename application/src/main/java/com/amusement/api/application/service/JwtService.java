package com.amusement.api.application.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    // 1. Inyectamos las propiedades de application.properties
    private final SecretKey secretKey;
    private final long jwtExpirationMs;

    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expiration-ms}") long expiration) {
        // 2. Convertimos el string secreto en una clave segura para firmar
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.jwtExpirationMs = expiration;
    }

    // 3. Este método genera el token cuando el login es exitoso
    public String generateToken(Authentication authentication) {
        String username = authentication.getName(); // El email del usuario
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // (Más adelante añadiremos aquí los métodos para "validar" el token)
}