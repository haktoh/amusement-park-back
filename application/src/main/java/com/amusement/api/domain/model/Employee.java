package com.amusement.api.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Employee {
    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;}