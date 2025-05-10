package com.firstgroup.gamemanagerapi.request;

import java.util.Optional;

public record PublisherPatchRO (
        Optional<String> name,
        Optional<String> email,
        Optional<String> description
) {}
