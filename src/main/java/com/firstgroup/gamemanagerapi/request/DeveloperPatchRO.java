package com.firstgroup.gamemanagerapi.request;

import java.util.Optional;

public record DeveloperPatchRO (
    Optional<String> name,
    Optional<String> email,
    Optional<String> description
        ) {}
