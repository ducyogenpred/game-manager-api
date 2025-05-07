package com.firstgroup.gamemanagerapi.request;

import jakarta.validation.constraints.*;

public record FavoriteRO(
        @NotNull long userId,
        @NotNull long gameId
) {}
