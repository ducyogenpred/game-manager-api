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
    public List <GenreDTO> getAllGenres(){
        return genreRepository.findAllByOrderByName()
                .stream()
                .map(genreMapper::toDto)
                .toList();
    }

    public GenreDTO getGenreById (Long id){
        return genreMapper.toDto(genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre with id" + id + "already exist")));
    }

    public GenreDTO getGenreByName(String name){
        return genreMapper.toDto(genreRepository.findByName(name)
                .orElseThrow (() -> new EntityNotFoundException("Genre with name" + name + "already exist")));
    }

    public List<GenreDTO> searchGenreByName(String nameFragment){
        return genreRepository.findByNameContainingIgnoreCase(nameFragment)
                .stream()
                .map(genreMapper::toDto)
                .toList();
    }

    @Transactional
    public GenreDTO updateGenre (Long id, @Valid GenreRO ro) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre with id" + id + "already exist"));
        if (!genre.getName().equals(ro.name()) &&
                genreRepository.existByName(ro.name())) {
            throw new IllegalArgumentException("Genre with name" + ro.name() + " already exist");
        }

        genre.setName(ro.name());
        genre.setDescription(ro.description());

        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Transactional
    public Genre deleteGenre (Long id){
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre with id" + id + "already exist"));

        genreRepository.delete(genre);
        return genre;


    }

}
