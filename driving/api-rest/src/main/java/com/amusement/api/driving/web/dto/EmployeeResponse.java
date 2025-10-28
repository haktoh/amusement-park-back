package com.amusement.api.driving.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeResponse {
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}