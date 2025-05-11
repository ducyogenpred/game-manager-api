package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.*;

public record ReviewRO(
        @NotBlank(message = "Title must not be blank.")
        String title,

        @NotBlank(message = "Content must not be blank.")
        String content,

        @Positive(message = "Rating must be a positive number.")
        @DecimalMin(value = "0.0", message = "Rating must be at least 0.")
        @DecimalMax(value = "5.0", message = "Rating must be at most 5.")
        double rating,

        @NotNull(message = "User ID is required.")
        @Positive(message = "User ID must be positive.")
        Long userId,

        @NotNull(message = "Game ID is required.")
        @Positive(message = "Game ID must be positive.")
        Long gameId
) {}
