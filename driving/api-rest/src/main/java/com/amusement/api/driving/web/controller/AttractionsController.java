package com.amusement.api.driving.web.controller;

import com.amusement.api.application.port.driving.GetAttractionsUseCase;
import com.amusement.api.domain.model.Attraction;
import com.amusement.api.driving.web.dto.AttractionResponse;
import com.amusement.api.driving.web.mapper.AttractionApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attractions")
@RequiredArgsConstructor
public class AttractionsController {
    private final AttractionApiMapper attractionApiMapper;
    private final GetAttractionsUseCase getAttractionsUseCase;

    @GetMapping
    public ResponseEntity<List<AttractionResponse>> getAllAttractions() {
        List<Attraction> attractions = getAttractionsUseCase.getAttractions();
        List<AttractionResponse> response = attractionApiMapper.toResponseList(attractions);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttractionResponse> getAttractionById(@PathVariable Long id) {
        Attraction attraction = getAttractionsUseCase.getAttractionById(id);
        var response = attractionApiMapper.toResponse(attraction);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttractionById(@PathVariable Long id) {
        getAttractionsUseCase.deleteAttractionById(id);
        return ResponseEntity.noContent().build();
    }
}