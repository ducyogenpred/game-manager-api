package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRO(
        @NotBlank(message = "First name must not be blank.")
        @Pattern(regexp = "[A-Za-z]+", message = "First name should only contain letters.")
        String firstName,

        @NotBlank(message = "First name must not be blank.")
        @Pattern(regexp = "[A-Za-z]+", message = "Middle name should only contain letters.")
        String middleName,

        @NotBlank(message = "First name must not be blank.")
        @Pattern(regexp = "[A-Za-z]+", message = "Last name should only contain letters.")
        String lastName,

        @NotBlank(message = "First name must not be blank.")
        @Size(min = 4)
        String displayName,

        @NotBlank(message = "Email must not be blank.")
        @Email
        String email,

        @NotBlank(message = "Phone number must not be blank.")
        @Pattern(regexp = "\\d{10}",
                message = "Phone number must have exactly 10 digits.")
        String phoneNumber,

        @NotBlank(message = "Password must not be blank.")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\\\S+$).{8,}",
                message = "Password must have at least one digit, one lowercase letter, one uppercase letter, and one special character.")
        String password,

        @NotNull(message = "Birthdate is required.")
        @Past(message = "Birthdate must not be in the future.")
        LocalDate birthDate,

        String description
) {}
