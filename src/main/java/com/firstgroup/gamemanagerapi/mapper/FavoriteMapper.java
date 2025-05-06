package com.firstgroup.gamemanagerapi.mapper;

import com.firstgroup.gamemanagerapi.dto.FavoriteDTO;

import com.firstgroup.gamemanagerapi.entity.Favorite;

import com.firstgroup.gamemanagerapi.request.FavoriteRO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FavoriteMapper {
    FavoriteDTO toDto(Favorite favorite);

    Favorite toEntity(FavoriteDTO dto);

    FavoriteRO toRO(Favorite favorite);
}
