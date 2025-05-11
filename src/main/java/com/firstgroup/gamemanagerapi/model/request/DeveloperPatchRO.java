package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record DeveloperPatchRO (
        @Pattern(regexp = "^\\S.*$", message = "Name must not start with a space")
        String name,

        @Pattern(regexp = "^\\S.*$", message = "Description must not start with a space.")
        String description,

        @Email(message = "Email must be a valid email address.")
        String email
) {
    public boolean isEmpty() {
        return name == null && description == null && email == null;
    }
}
