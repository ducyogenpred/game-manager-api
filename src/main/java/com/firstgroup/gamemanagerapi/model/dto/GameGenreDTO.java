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
public class GameGenreDTO {
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private GenreDTO genre;
    private GameDTO game;
}
