package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.model.entity.Developer;
import com.firstgroup.gamemanagerapi.model.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.model.request.DeveloperPatchRO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {
    DeveloperDTO toDto(Developer developer);
    Developer toEntity(DeveloperRO developer);
    void updateDeveloperFromPatchRo(DeveloperPatchRO ro, @MappingTarget Developer entity);
}
