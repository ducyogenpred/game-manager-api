package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record UserGameRO(
        @NotNull(message = "Purchased date must not be blank.")
        @Past(message = "Purchased date must not be in the future.")
        LocalDateTime purchaseAt,

        @NotNull(message = "User ID is required.")
        @Positive(message = "User ID must be positive.")
        Long userId,

        @NotNull(message = "Game ID is required.")
        @Positive(message = "Game ID must be positive.")
        Long gameId
) {}
