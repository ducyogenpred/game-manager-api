package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

public record PublisherDTO(
        long id,
        String name,
        String description,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Set<Long> gameIds
) {}
