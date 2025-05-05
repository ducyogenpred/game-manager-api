package com.firstgroup.gamemanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DeveloperDTO {
    private long id;
    private String name;
    private String email;
    private String description;
    private Integer reviewCount;
    private Double ratingAverage;
}
