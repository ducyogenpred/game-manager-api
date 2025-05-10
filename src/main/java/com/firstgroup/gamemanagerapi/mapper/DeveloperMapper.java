package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.request.DeveloperPatchRO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {
    DeveloperDTO toDto(Developer developer);
    Developer toEntity(DeveloperRO developer);
    void updateDeveloperFromPatchRo(DeveloperPatchRO ro, @MappingTarget Developer entity);
}
