package com.firstgroup.gamemanagerapi.request;

public record DeveloperRO(

) {
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import java.time.LocalDate;

public class DeveloperRO {
    @NotBlank String name,
    @NotBlank String email,
    @NotBlank String description,
    @NotBlank Integer reviewCount,
    @NotBlank Double ratingAverage,
    @NotBlank LocalDateTime createdAt,
    @NotBlank LocalDateTime updatedAt,
}
