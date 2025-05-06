package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.request.DeveloperRo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DeveloperMapper {
    DeveloperDTO toDto(Developer developer);
    Developer toEntity(Developer developer);
    DeveloperRO toRo(Developer developer);
}
