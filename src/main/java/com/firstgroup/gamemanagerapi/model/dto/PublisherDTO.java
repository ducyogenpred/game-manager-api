package com.firstgroup.gamemanagerapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublisherDTO {
    private long id;
    private String name;
    private String description;
    private String email;
    private int reviewCount;
    private double ratingAverage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
