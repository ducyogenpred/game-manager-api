package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PublisherRO(
        @NotBlank(message = "Publisher name must not be blank") String name,
        String Description,
        @NotBlank(message = "Email must not be blank.") @Email String email
) {}

