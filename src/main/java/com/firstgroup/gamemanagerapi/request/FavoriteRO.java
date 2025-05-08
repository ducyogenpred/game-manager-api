package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FavoriteRO(
        @NotNull(message = "User ID is required.")
        @Positive(message = "User ID must be positive.")
        Long userId,

        @NotNull(message = "Game ID is required.")
        @Positive(message = "Game ID must be positive.")
        Long gameId
) {}
