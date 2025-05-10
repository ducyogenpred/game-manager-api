package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.UserGameDTO;
import com.firstgroup.gamemanagerapi.entity.UserGame;
import com.firstgroup.gamemanagerapi.request.UserGamePatchRO;
import com.firstgroup.gamemanagerapi.request.UserGameRO;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserGameMapper {
    UserGameDTO toUserGameDTO(UserGame entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "hoursPlayed", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    UserGame toEntity(UserGameRO ro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "hoursPlayed", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    @Mapping(source = "isFavorite", target = "isFavorite")
    void updateFromUserGameRO(UserGamePatchRO ro, @MappingTarget UserGame entity);
}
