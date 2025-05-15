package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

public record DeveloperDTO(
        long id,
        String name,
        String email,
        String description,
        int reviewCount,
        double ratingAverage,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Set<Long> gameIds
) {}
