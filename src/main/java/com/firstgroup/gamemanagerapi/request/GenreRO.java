package com.firstgroup.gamemanagerapi.request;

import com.firstgroup.gamemanagerapi.entity.Genre;
import jakarta.validation.constraints.NotBlank;

public class GenreRO {
    @NotBlank Genre genre;
    @NotBlank  String name;
    @NotBlank  String description;

}
