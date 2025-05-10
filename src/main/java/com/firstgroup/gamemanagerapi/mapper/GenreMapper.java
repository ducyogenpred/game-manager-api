package com.firstgroup.gamemanagerapi.mapper;


import com.firstgroup.gamemanagerapi.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.entity.Genre;
import com.firstgroup.gamemanagerapi.request.GenrePatchRO;
import com.firstgroup.gamemanagerapi.request.GenreRO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toDto(Genre genre);
    Genre toEntity(GenreRO ro);

    void updateGenreFromPatchRo(GenrePatchRO ro, @MappingTarget Genre entity);
}
