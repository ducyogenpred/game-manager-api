package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import java.time.LocalDate;

public record DeveloperRO (
    @NotBlank String name,
    @NotBlank String email,
    @NotBlank String description,
    @NotBlank Integer reviewCount,
    @NotBlank Double ratingAverage,
    @NotBlank LocalDateTime createdAt,
    @NotBlank LocalDateTime updatedAt
) {}
