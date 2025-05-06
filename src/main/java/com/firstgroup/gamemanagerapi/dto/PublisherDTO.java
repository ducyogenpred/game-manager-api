package com.firstgroup.gamemanagerapi.dto;


import com.firstgroup.gamemanagerapi.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PublisherDTO {

    private long id;
    private String name;
    private String description;
    private String email;
    private Integer reviewCount;
    private Double ratingAverage;
    private LocalDateTime updatedAt;
    private Set<Game> game;
}
