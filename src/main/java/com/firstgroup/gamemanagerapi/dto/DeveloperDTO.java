package com.firstgroup.gamemanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
public class DeveloperDTO {
    private long id;
    private String name;
    private String email;
    private String description;
    private int reviewCount;
    private double ratingAverage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DeveloperDTO(long id, String name, String email, String description, int reviewCount, double ratingAverage, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.reviewCount = reviewCount;
        this.ratingAverage = ratingAverage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
