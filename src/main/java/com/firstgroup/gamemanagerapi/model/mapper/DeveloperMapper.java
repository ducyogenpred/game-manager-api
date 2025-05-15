package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.model.entity.Developer;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.model.request.DeveloperPatchRO;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper( componentModel = "spring")
public interface DeveloperMapper {

    @Mapping(target = "gameIds", source = "games")
    DeveloperDTO toDto(Developer entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    Developer toEntity(DeveloperRO ro);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    void updateFromPutRo(DeveloperRO ro, @MappingTarget Developer entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    void updateFromPatchRo(DeveloperPatchRO ro, @MappingTarget Developer entity);

    default Set<Long> mapGameIds(Set<Game> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(Game::getId)
                .collect(Collectors.toSet());
    }
}
