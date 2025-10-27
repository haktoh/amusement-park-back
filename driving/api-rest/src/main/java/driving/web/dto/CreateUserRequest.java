package com.amusement.api.driving.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequest {

    // Usamos 'validation' para que Spring valide los datos por nosotros
    @NotBlank(message = "El DNI no puede estar vacío")
    private String dni;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String surname;

    @Email(message = "El formato del email no es válido")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    private Integer age;
}