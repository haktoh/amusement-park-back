package com.amusement.api.driven.persistence.jpa.mapper;

import com.amusement.api.domain.model.Attraction;
import com.amusement.api.domain.model.User;
import com.amusement.api.driven.persistence.jpa.entity.AttractionEntity;
import com.amusement.api.driven.persistence.jpa.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Le decimos a MapStruct que genere un Bean
public interface AttractionPersistenceMapper {

    // Convierte el Modelo de Dominio -> Entidad de BBDD
    AttractionEntity toEntity(Attraction attraction);

    // Convierte la Entidad de BBDD -> Modelo de Dominio
    Attraction toDomain(AttractionEntity attraction);
}