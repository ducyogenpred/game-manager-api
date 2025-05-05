package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserRO(
        long id,
        @NotBlank String firstName,
        @NotBlank String middleName,
        @NotBlank String lastName,
        @NotBlank @Size(min = 4) String displayName,
        @NotBlank @Email String email,
        @NotBlank String phoneNumber,
        @NotBlank @Size(min = 8) String password,
        @NotNull LocalDate birthDate,
        String description
) {}
