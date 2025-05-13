package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDateTime;

public record DeveloperDTO(
        long id,
        String name,
        String email,
        String description,
        int reviewCount,
        double ratingAverage,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
