package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PublisherPatchRO (
        @Pattern(regexp = "^\\S.*$", message = "Publisher name must not start with a space.")
        String name,

        @Pattern(regexp = "^\\S.*$", message = "Description must not start with a space.")
        String description,

        @NotBlank(message = "Email must not be blank.")
        @Email(message = "Email must be a valid email address.")
        String email
) {
    public boolean isEmpty() {
        return name == null && description == null && email == null;
    }
}
