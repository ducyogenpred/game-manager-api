    package com.firstgroup.gamemanagerapi.request;

    import jakarta.validation.constraints.NotBlank;

    import java.time.LocalDate;

    public record GameRO(
            @NotBlank String title,
            @NotBlank String description,
            @NotBlank LocalDate releaseDate,
            @NotBlank String publisher,
            @NotBlank String developer
    ) {}
