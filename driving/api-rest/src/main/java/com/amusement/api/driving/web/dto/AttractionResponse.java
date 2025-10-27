package com.amusement.api.driving.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttractionResponse {
    private Long id;
    private String name;
    private Integer minHeight;
    private Integer maxHeight;
    private Integer length;
}