package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

public record GamePatchRO(
        String title,
        String description,
        LocalDate releaseDate,
        long publisherId,
        long developerId
) {
    public boolean isEmpty() {
        return Stream.of(title, releaseDate, publisherId, developerId).allMatch(Objects::isNull);
    }
}
