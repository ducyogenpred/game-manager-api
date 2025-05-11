package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.model.entity.Developer;
import com.firstgroup.gamemanagerapi.model.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.model.request.DeveloperPatchRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {
    DeveloperDTO toDto(Developer developer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Developer toEntity(DeveloperRO developer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateDeveloperFromPatchRo(DeveloperPatchRO ro, @MappingTarget Developer entity);
}
