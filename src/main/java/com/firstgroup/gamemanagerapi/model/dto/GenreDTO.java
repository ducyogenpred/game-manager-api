package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDateTime;

public record GenreDTO(
        long id,
        String name,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        int gameCount
) {}
