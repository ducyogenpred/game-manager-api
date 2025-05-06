package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class DeveloperRO {
    @NotBlank String name,
    @NotBlank String description,
    @NotBlank @Email String email
}
