package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.GameGenreDTO;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.entity.GameGenre;
import com.firstgroup.gamemanagerapi.model.entity.Genre;
import com.firstgroup.gamemanagerapi.model.request.GameGenreRO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameGenreMapper {

    @Mapping(target = "gameId", source = "game.id")
    @Mapping(target = "genreId", source = "genre.id")
    GameGenreDTO toDto(GameGenre gameGenre);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "game", source = "game")
    @Mapping(target = "genre", source = "genre")
    GameGenre toEntity(GameGenreRO ro, Game game, Genre genre);
}
