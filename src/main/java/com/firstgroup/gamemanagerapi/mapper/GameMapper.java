package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.GameDTO;
import com.firstgroup.gamemanagerapi.entity.Game;
import com.firstgroup.gamemanagerapi.request.GameRO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameDTO toDto(Game game);

    Game toEntity(GameDTO dto);

    GameRO toRO(Game game);
}
