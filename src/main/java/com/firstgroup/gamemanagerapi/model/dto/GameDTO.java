package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record GameDTO(
        long id,
        String title,
        String description,
        LocalDate releaseDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
