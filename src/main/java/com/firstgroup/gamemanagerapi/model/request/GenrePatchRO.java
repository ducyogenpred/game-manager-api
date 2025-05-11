package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.Pattern;

public record GenrePatchRO (
        @Pattern(regexp = "^\\S.*$", message = "Genre name must not start with a space.")
        String name,

        @Pattern(regexp = "^\\S.*$", message = "Description must not start with a space.")
        String description
)  {
    public boolean isEmpty() {
        return name == null && description == null;
    }
}



