package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDate;
import java.util.Set;

public record GamePatchRO(
        String title,
        LocalDate releaseDate,
        long publisherId,
        long developerId
) {}
