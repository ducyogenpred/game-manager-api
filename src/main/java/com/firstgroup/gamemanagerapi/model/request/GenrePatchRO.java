package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record GenrePatchRO (
        @NotBlank(message = "Genre name must not be blank.")
        String name,

        @NotBlank(message = "Description must not be blank.")
        @Pattern(regexp = "^\\S.*$", message = "Description must not start with a space.")
        String description
)  {
    public boolean isEmpty() {
        return name == null && description == null;
    }
}



