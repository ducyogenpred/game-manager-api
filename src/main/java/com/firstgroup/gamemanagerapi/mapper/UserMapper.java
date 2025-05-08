package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User entity);
    User toEntity(UserRO ro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromPatchRo(UserPatchRO ro, @MappingTarget User user);

    default <T> T map(Optional<T> optional) {
        return optional.orElse(null);
    }
}