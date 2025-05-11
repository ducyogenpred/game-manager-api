package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.GameDTO;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.request.GamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GameRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDTO toDto(Game game);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "users", ignore = true)
    Game toEntity(GameRO ro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "users", ignore = true)
    void updateFromGamePatchRO(GamePatchRO ro, @MappingTarget Game entity);
}
