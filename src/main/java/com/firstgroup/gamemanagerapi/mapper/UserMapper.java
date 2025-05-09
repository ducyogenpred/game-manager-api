package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "games", ignore = true)
    User toEntity(UserRO ro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "games", ignore = true)
    void updateUserFromPatchRo(UserPatchRO ro, @MappingTarget User entity);
}