package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.entity.Genre;
import com.firstgroup.gamemanagerapi.mapper.GenreMapper;
import com.firstgroup.gamemanagerapi.repository.GenreRepository;
import com.firstgroup.gamemanagerapi.request.GenrePatchRO;
import com.firstgroup.gamemanagerapi.request.GenreRO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor()
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Transactional
    public GenreDTO createGenre (@Valid GenreRO ro){
        if (genreRepository.existsByName(ro.name())){
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

    public GenreDTO getGenreById(Long id){
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
    public  GenreDTO patchGenre(Long id, @Valid GenrePatchRO ro) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre with this ID does not exist."));

        if (ro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No fields provided for update.");
        }

        if (ro.name() != null && !ro.name().equals(genre.getName())) {
            if (!genreRepository.existsByName(ro.name())) {
                genre.setName(ro.name());
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Genre with this display name already exists.");
            }
        }
        genreMapper.updateGenreFromPatchRo(ro, genre);
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
