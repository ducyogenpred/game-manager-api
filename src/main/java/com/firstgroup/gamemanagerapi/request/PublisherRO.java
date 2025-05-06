package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

    public record PublisherRO (
        @NotBlank String name,
        @NotBlank String Description,
        @NotBlank @Email String email
    ) {}

