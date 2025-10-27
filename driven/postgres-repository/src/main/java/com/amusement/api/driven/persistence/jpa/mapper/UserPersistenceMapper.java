package com.amusement.api.driven.persistence.jpa.mapper;

import com.amusement.api.domain.model.User;
import com.amusement.api.driven.persistence.jpa.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Le decimos a MapStruct que genere un Bean
public interface UserPersistenceMapper {

    // Convierte el Modelo de Dominio -> Entidad de BBDD
    UserEntity toEntity(User user);

    // Convierte la Entidad de BBDD -> Modelo de Dominio
    User toDomain(UserEntity entity);
}