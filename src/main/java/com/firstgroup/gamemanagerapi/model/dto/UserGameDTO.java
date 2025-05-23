package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDateTime;

public record UserGameDTO(
        long id,
        LocalDateTime purchasedAt,
        boolean favourite,
        long userId,
        long gameId
) {}
