package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record GameRO(
        long userId,
        long gameId,
        @NotBlank String title,
        @NotBlank String description,
        @NotNull LocalDate releaseDate
) {}
