package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LoginRO (
        @Pattern(regexp = "^\\S.*$", message = "Display name must not start with a space.")
        @NotBlank(message = "Display name must not be blank.")
        String displayName,

        @NotBlank(message = "Password must not be blank.")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}",
                message = "Password must include 1 digit, 1 lowercase, 1 uppercase, and 1 special character.")
        String password
) {}
