package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRO(
        @NotBlank
        String firstName,

        @NotBlank
        String middleName,

        @NotBlank
        String lastName,

        @NotBlank
        @Size(min = 4)
        String displayName,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{10}",
                message = "Mobile number must have exactly 10 digits")
        String phoneNumber,

        @NotBlank
        @Size(min = 8)
        String password,

        @NotNull
        LocalDate birthDate,

        String description
) {}
