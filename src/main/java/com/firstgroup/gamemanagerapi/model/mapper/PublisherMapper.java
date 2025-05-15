package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.entity.Publisher;
import com.firstgroup.gamemanagerapi.model.request.PublisherPatchRO;
import com.firstgroup.gamemanagerapi.model.request.PublisherRO;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    @Mapping(target = "gameIds", source = "games")
    PublisherDTO toDto(Publisher entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    Publisher toEntity(PublisherRO ro);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    void updateFromPutRo(PublisherRO ro, @MappingTarget Publisher entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "games", ignore = true)
    void updateFromPatchRo(PublisherPatchRO ro, @MappingTarget Publisher entity);

    default Set<Long> mapGameIds(Set<Game> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(Game::getId)
                .collect(Collectors.toSet());
    }
}