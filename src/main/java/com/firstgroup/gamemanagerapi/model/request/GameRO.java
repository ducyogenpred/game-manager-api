package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record GameRO(
        @NotBlank(message = "Title must not be blank.")
        @Size(min = 4, message = "Title must have at least 4 characters.")
        String title,

        @NotBlank(message = "Description must not be blank.") String description,

        @NotNull(message = "Release date is required.")
        @PastOrPresent(message = "Release date must be set in the past or present.")
        LocalDate releaseDate,

        @NotNull(message = "Publisher ID is required.")
        @Positive(message = "Publisher ID must be positive.")
        long publisherId,

        @NotNull(message = "Developer ID is required.")
        @Positive(message = "Developer ID must be positive.")
        long developerId
) {}
