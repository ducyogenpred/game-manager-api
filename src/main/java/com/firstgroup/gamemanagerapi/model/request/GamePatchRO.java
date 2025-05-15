package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

public record GamePatchRO(

        @Size(min = 4, message = "Title must have at least 4 characters.")
        String title,
        String description,

        @PastOrPresent(message = "Release date must be set in the past or present.")
        LocalDate releaseDate,

        @Positive(message = "Publisher ID must be positive.")
        Long publisherId,

        @Positive(message = "Publisher ID must be positive.")
        Long developerId
) {
    public boolean isEmpty() {
        return Stream.of(title, releaseDate, publisherId, developerId).allMatch(Objects::isNull);
    }
}
