package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.UserGameDTO;
import com.firstgroup.gamemanagerapi.model.entity.UserGame;
import com.firstgroup.gamemanagerapi.model.request.UserGamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.UserGameRO;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserGameMapper {

    UserGameDTO toUserGameDTO(UserGame entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "hoursPlayed", ignore = true)
    UserGame toEntity(UserGameRO ro);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "hoursPlayed", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    void updateFromPatchRo(UserGamePatchRO ro, @MappingTarget UserGame entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchasedAt", ignore = true)
    @Mapping(target = "hoursPlayed", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    void updateFromPutRo(UserGamePatchRO ro, @MappingTarget UserGame entity);
}
