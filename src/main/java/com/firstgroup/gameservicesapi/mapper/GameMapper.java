package com.firstgroup.gameservicesapi.mapper;

import com.firstgroup.gameservicesapi.dto.GameDTO;
import com.firstgroup.gameservicesapi.entity.Game;
import com.firstgroup.gameservicesapi.request.GameRO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameDTO toDto(Game game);

    Game toEntity(GameRO ro);

    GameRO toRO(Game game);
}
