package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDateTime;

public record PublisherDTO(
        long id,
        String name,
        String description,
        String email,
        int reviewCount,
        double ratingAverage,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
