package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.NotBlank;


public record GenreRO {
    @NotBlank Genre genre,
    @NotBlank  String name,
    @NotBlank  String description,

}
