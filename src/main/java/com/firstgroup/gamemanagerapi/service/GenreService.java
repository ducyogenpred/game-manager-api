package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.entity.Genre;
import com.firstgroup.gamemanagerapi.mapper.GenreMapper;
import com.firstgroup.gamemanagerapi.repository.GenreRepository;
import com.firstgroup.gamemanagerapi.request.GenreRO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor (onConstructor_ = @Autowired)
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Transactional
    public GenreDTO createGenre (@Valid GenreRO ro){
        if (genreRepository.existByName(ro.name())){
            throw new IllegalArgumentException("Genre name already exist!");
        }
        Genre genre = genreMapper.toEntity(ro);
        return genreMapper.toDto(genreRepository.save(genre));
    }


}
