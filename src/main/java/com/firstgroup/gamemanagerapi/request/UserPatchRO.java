package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDate;
import java.util.Optional;

public record UserPatchRO(
        Optional<String> firstName,
        Optional<String> middleName,
        Optional<String> lastName,
        Optional<String> displayName,
        Optional<String> email,
        Optional<String> phoneNumber,
        Optional<String> password,
        Optional<LocalDate> birthDate,
        Optional<String> description
) {}
