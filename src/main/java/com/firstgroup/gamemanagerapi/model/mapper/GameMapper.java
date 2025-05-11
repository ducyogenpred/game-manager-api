package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.GameDTO;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.request.GamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GameRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDTO toDto(Game game);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "users", ignore = true)
//    @Mapping(source = "developerId", target = "developer")
//    @Mapping(source = "publisherId", target = "publisher")
    Game toEntity(GameRO ro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "users", ignore = true)
//    @Mapping(source = "developerId", target = "developer")
//    @Mapping(source = "publisherId", target = "publisher")
    void updateFromGamePatchRO(GamePatchRO ro, @MappingTarget Game entity);

    /*@AfterMapping
    default void afterMapping(GameRO ro, @MappingTarget Game game) {
        if (ro.developerId() != null) {
            game.setDeveloper(developerRepository.getReferenceById(ro.getDeveloperId()));
        }
        if (ro.getPublisherId() != null) {
            game.setPublisher(publisherRepository.getReferenceById(ro.getPublisherId()));
        }
    }*/
}
