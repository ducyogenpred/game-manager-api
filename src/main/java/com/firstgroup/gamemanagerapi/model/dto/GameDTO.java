package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public record GameDTO(
        long id,
        String title,
        String description,
        LocalDate releaseDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        long developerId,
        String developerName,
        long publisherId,
        String publisherName,
        Set<String> genres,
        Set<Long> userIds
) {}
