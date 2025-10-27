package com.amusement.api.driving.web.mapper;

import com.amusement.api.domain.model.User;
import com.amusement.api.driving.web.dto.CreateUserRequest;
import com.amusement.api.driving.web.dto.UserResponse;
import org.mapstruct.Mapper;

// Le decimos a MapStruct que genere un Bean de Spring
@Mapper(componentModel = "spring")
public interface UserApiMapper {

    // Convierte el DTO de Petición -> Modelo de Dominio
    User toDomain(CreateUserRequest request);

    // Convierte el Modelo de Dominio -> DTO de Respuesta
    UserResponse toResponse(User user);
}