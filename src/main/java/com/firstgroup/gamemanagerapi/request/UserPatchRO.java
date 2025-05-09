package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

public record UserPatchRO(
        String firstName,
        String middleName,
        String lastName,
        String displayName,
        String email,
        String phoneNumber,
        String password,
        LocalDate birthDate,
        String description
) {
    public boolean isEmpty() {
        return Stream.of(firstName, middleName, lastName, displayName, email, phoneNumber, password, birthDate, description)
                .allMatch(Objects::isNull);
    }
}
