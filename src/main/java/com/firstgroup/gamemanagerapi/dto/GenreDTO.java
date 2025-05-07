package com.firstgroup.gamemanagerapi.dto;

import com.firstgroup.gamemanagerapi.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GenreDTO {
    private long id;
    private String name;
    private String description;
    private Set<Game> genreGames;

}
