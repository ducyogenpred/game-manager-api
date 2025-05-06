package com.firstgroup.gamemanagerapi.mapper;


import com.firstgroup.gamemanagerapi.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.entity.Genre;
import com.firstgroup.gamemanagerapi.request.GenreRO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toDto(Genre genre);

    Genre toEntity(GenreDTO dto);

    GenreRO toRO(Genre genre);



}
