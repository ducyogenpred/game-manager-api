package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LoginRO (
        String displayName,
        String password
) {}
