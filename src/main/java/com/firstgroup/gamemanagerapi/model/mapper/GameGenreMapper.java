package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.GameGenreDTO;
import com.firstgroup.gamemanagerapi.model.entity.GameGenre;
import com.firstgroup.gamemanagerapi.model.request.GameGenreRO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameGenreMapper {

    GameGenreDTO toDto(GameGenre entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    GameGenre toEntity(GameGenreRO ro);
}
