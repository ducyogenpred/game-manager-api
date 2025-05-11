package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.model.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.model.entity.Genre;
import com.firstgroup.gamemanagerapi.model.mapper.GenreMapper;
import com.firstgroup.gamemanagerapi.repository.GenreRepository;
import com.firstgroup.gamemanagerapi.model.request.GenrePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GenreRO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Transactional
    public GenreDTO createGenre(@Valid GenreRO ro) {
        Genre genre = genreMapper.toEntity(ro);

        try {
            return genreMapper.toDto(genreRepository.save(genre));
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Genre with this name already exists.");
        }
    }

    public GenreDTO getGenreById(long id) {
        return genreMapper.toDto(genreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre with this ID does not exist.")));
    }

    public GenreDTO getGenreByName(String name) {
        return genreMapper.toDto(genreRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre with this name does not exist.")));
    }

    @Transactional
    public GenreDTO patchGenre(Long id, @Valid GenrePatchRO ro) {
        if (ro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No fields provided for update.");
        }

        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre with this ID does not exist."));

        if (ro.name() != null && !ro.name().equals(genre.getName())) {
            if (genreRepository.existsByName(ro.name())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Genre with this name already exists.");
            }
            genre.setName(ro.name());
        }

        genreMapper.updateGenreFromPatchRo(ro, genre);
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Transactional
    public void deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre with this ID does not exist."));
        genreRepository.delete(genre);
    }
}