package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.model.entity.Publisher;
import com.firstgroup.gamemanagerapi.model.request.PublisherPatchRO;
import com.firstgroup.gamemanagerapi.model.request.PublisherRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDTO toDto(Publisher entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Publisher toEntity(PublisherRO ro);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateFromPutRo(PublisherPatchRO ro, @MappingTarget Publisher entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "ratingAverage", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateFromPatchRo(PublisherPatchRO ro, @MappingTarget Publisher entity);
}