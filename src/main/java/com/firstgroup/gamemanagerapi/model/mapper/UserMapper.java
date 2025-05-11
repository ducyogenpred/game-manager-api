package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.UserDTO;
import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.model.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.model.request.UserRO;
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