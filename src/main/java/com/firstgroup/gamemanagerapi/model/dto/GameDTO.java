package com.firstgroup.gamemanagerapi.model.dto;

import com.firstgroup.gamemanagerapi.model.entity.Developer;
import com.firstgroup.gamemanagerapi.model.entity.Publisher;

import java.time.LocalDateTime;

public record GameDTO(
        long id,
        String title,
        String description,
        LocalDateTime releaseDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Publisher publisher,
        Developer developer
) {}
