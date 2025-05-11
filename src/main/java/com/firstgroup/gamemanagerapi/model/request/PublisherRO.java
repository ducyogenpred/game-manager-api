package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PublisherRO(
        @NotBlank(message = "Publisher name must not be blank.")
        String name,

        @Pattern(regexp = "^\\S.*$", message = "Description must not start with a space.")
        String description,

        @NotBlank(message = "Email must not be blank.")
        @Email(message = "Email must be a valid email address.")
        String email
) {}

