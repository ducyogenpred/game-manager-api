package com.firstgroup.gameservicesapi.mapper;

import com.firstgroup.gameservicesapi.dto.UserDTO;
import com.firstgroup.gameservicesapi.entity.User;
import com.firstgroup.gameservicesapi.request.UserRO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRO ro);

    UserDTO toDto(User entity);

    @Mapping(target = "id", ignore = true)
    void updateUserFromRO(UserRO ro, @MappingTarget User user);
}