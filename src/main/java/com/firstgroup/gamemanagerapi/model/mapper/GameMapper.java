package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.GameDTO;
import com.firstgroup.gamemanagerapi.model.entity.*;
import com.firstgroup.gamemanagerapi.model.request.GamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GameRO;
import org.mapstruct.*;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GameMapper {

    @Mapping(target = "genres", source = "genres")
    @Mapping(target = "userIds", source = "users")
    @Mapping(target = "developerId", source = "developer.id")
    @Mapping(target = "publisherId", source = "publisher.id")
    @Mapping(target = "developerName", source = "developer.name")
    @Mapping(target = "publisherName", source = "publisher.name")
    GameDTO toDto(Game game);

    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "ro.description")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "developer", source = "developer")
    Game toEntity(GameRO ro, Publisher publisher, Developer developer);

    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "ro.description")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "developer", source = "developer")
    void updateFromPutRo(GameRO ro, @MappingTarget Game game, Publisher publisher, Developer developer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "developer", ignore = true)
    void updateFromPatchRo(GamePatchRO ro, @MappingTarget Game game);

    default Set<String> mapGenres(Set<GameGenre> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(GameGenre::getGenre)
                .filter(Objects::nonNull)
                .map(Genre::getName)
                .collect(Collectors.toSet());
    }

    default Set<Long> mapUserIds(Set<UserGame> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(UserGame::getUser)
                .filter(Objects::nonNull)
                .map(User::getId)
                .collect(Collectors.toSet());
    }
}
