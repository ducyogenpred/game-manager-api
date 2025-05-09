package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDateTime;

public record UserGamePatchRO(
        LocalDateTime purchaseAt,
        boolean isFavorite,
        long userId,
        long gameId
) {}
