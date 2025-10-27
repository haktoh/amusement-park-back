package com.amusement.api.driving.web.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponse {
    // No devolvemos la contraseña!
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private LocalDateTime emailVerifiedAt;
}