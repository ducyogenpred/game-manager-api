package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import org.mapstruct.Mapper;


@Mapper
public interface DeveloperMapper {

    Developer toEntity(DeveloperRO ro);
    DeveloperDTO toDto(Developer entity);
    DeveloperRO toRO (Developer developer);
}
