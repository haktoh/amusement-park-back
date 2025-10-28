package com.amusement.api.driven.persistence.jpa.mapper;

import com.amusement.api.domain.model.Attraction;
import com.amusement.api.driven.persistence.jpa.entity.AttractionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") // Le decimos a MapStruct que genere un Bean
public interface AttractionPersistenceMapper {

    // Convierte el Modelo de Dominio -> Entidad de BBDD
    List<AttractionEntity> toEntity(List<Attraction> attraction);

    // Convierte la Entidad de BBDD -> Modelo de Dominio
    List<Attraction> toDomain(List<AttractionEntity> attraction);

    AttractionEntity toEntity(Attraction attraction);

    Attraction toDomain(AttractionEntity attractionEntity);
}