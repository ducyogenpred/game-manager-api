package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.NotBlank;

public record GameRO(
        @NotBlank String title,
        @NotBlank String publisher,
        @NotBlank String developer
) {}
