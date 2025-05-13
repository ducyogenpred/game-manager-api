package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.model.entity.Genre;
import com.firstgroup.gamemanagerapi.model.request.GenreRO;
import com.firstgroup.gamemanagerapi.model.request.GenrePatchRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toDto(Genre genre);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    @Mapping(target = "genres", ignore = true)
    Genre toEntity(GenreRO ro);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    @Mapping(target = "genres", ignore = true)
    void updateFromPutRo(GenreRO ro, @MappingTarget Genre entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "game", ignore = true)
    @Mapping(target = "genres", ignore = true)
    void updateFromPatchRo(GenrePatchRO ro, @MappingTarget Genre entity);
}
