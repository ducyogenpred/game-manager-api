package com.firstgroup.gamemanagerapi.model.dto;

import java.time.LocalDate;

public record UserDTO(
        long id,
        String firstName,
        String middleName,
        String lastName,
        String displayName,
        String email,
        String phoneNumber,
        LocalDate birthDate,
        String description
) {}
