package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.*;

public record ReviewRO(
        @NotBlank(message = "Header must not be blank.") String header,
        @NotBlank(message = "Content must not be blank.") String content,

        @NotNull(message = "Rating is required.")
        @DecimalMin(value = "1.0", inclusive = true, message = "Rating must be at least 1.0.")
        @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be at most 5.0.")
        @NotNull double rating,

        @NotNull(message = "User ID is required.")
        @Positive(message = "User ID must be positive.")
        long userId,

        @NotNull(message = "Game ID is required.")
        @Positive(message = "Game ID must be positive.")
        long gameId
) {}
