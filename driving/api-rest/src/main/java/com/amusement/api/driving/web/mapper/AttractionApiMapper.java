package com.amusement.api.driving.web.mapper;

import com.amusement.api.domain.model.Attraction;
import com.amusement.api.driving.web.dto.AttractionResponse;
import org.mapstruct.Mapper;

import java.util.List;

// Le decimos a MapStruct que genere un Bean de Spring
@Mapper(componentModel = "spring")
public interface AttractionApiMapper {
    AttractionResponse toResponse(Attraction attraction);
    List<AttractionResponse> toResponseList(List<Attraction> attractions);
}