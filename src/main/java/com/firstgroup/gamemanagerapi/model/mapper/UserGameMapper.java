package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.UserGameDTO;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.model.entity.UserGame;
import com.firstgroup.gamemanagerapi.model.request.UserGamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.UserGameRO;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserGameMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "gameId", source = "game.id")
    UserGameDTO toDto(UserGame entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    UserGame toEntity(UserGameRO ro, User user, Game game);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    void updateFromPutRo(UserGameRO ro, @MappingTarget UserGame entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    void updateFromPatchRo(UserGamePatchRO ro, @MappingTarget UserGame entity);
}
