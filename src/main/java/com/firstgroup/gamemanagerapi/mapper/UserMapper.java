package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.request.UserRO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRO ro);

    UserDTO toDto(User entity);

    /*@Mapping(target = "id", ignore = true)
    void updateUserFromRO(UserRO ro, @MappingTarget User user);*/
}