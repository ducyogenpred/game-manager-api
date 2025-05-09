package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

public record UserGamePatchRO(
        LocalDateTime purchaseAt,
        boolean isFavorite,
        long userId,
        long gameId
) {
    public boolean isEmpty() {
        return Stream.of(purchaseAt, isFavorite, userId, gameId).allMatch(Objects::isNull);
    }
}
