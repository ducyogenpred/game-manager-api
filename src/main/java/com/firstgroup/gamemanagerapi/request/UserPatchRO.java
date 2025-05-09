package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDate;

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
) {}
