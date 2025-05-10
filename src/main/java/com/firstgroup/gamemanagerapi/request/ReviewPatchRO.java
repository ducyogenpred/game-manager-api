package com.firstgroup.gamemanagerapi.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;


public record ReviewPatchRO(

        String header,
        String Content,
        double rating,
        LocalDateTime updatedAt
) {}
