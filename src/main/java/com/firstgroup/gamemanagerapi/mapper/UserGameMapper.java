package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.UserGameDTO;
import com.firstgroup.gamemanagerapi.entity.UserGame;
import com.firstgroup.gamemanagerapi.request.UserRO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserGameMapper {
    UserGameDTO toUserGameDTO(UserGame entity);
    UserGame toEntity(UserRO ro);
}
