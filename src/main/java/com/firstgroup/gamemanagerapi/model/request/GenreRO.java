package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.NotBlank;

public record GenreRO(
        @NotBlank(message = "Genre name must not be blank.") String name,
        @NotBlank(message = "Description must not be blank.") String description
) {

}
