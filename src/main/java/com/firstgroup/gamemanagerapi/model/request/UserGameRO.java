package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record UserGameRO(
        @NotNull(message = "Purchased date must not be blank.")
        @PastOrPresent(message = "Purchased date must be set in the past or present.")
        LocalDateTime purchaseAt,

        Boolean isFavorite,

        @NotNull(message = "User ID is required.")
        @Positive(message = "User ID must be positive.")
        Long userId,

        @NotNull(message = "Game ID is required.")
        @Positive(message = "Game ID must be positive.")
        Long gameId
) {}
