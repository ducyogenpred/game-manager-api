package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDateTime;

public record GameGenreDTO(
        long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        long gameId,
        long genreId
) {}
