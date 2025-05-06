package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.entity.Publisher;
import com.firstgroup.gamemanagerapi.request.PublisherRO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDTO toDto (Publisher publisher);
    PublisherDTO toEntity (Publisher publisher);
    PublisherDTO toRo (Publisher publisher);
}
