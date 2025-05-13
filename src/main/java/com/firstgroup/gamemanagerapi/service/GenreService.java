package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.AlreadyExistsException;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.model.entity.Genre;
import com.firstgroup.gamemanagerapi.model.mapper.GenreMapper;
import com.firstgroup.gamemanagerapi.model.request.GenrePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GenreRO;
import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.repository.GenreRepository;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenreService {

    public static final String GENRES = "Genres";
    public static final String GENRE = "Genre";

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Transactional
    public GenreDTO save(GenreRO ro) {
        if (genreRepository.existsByName(ro.name())) {
            List<ErrorResponse.FieldError> errors = List.of(
                    new ErrorResponse.FieldError("name", "Genre name '" + ro.name() + "' already exists.", ro.name())
            );
            throw new AlreadyExistsException("Genre", errors);
        }

        Genre entity = genreMapper.toEntity(ro);
        Genre saved = genreRepository.save(entity);
        log.info(MessageUtils.saveSuccess(GENRE));
        return genreMapper.toDto(saved);
    }

    public List<GenreDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(GENRES));
        return genreRepository.findAll().stream()
                .map(genreMapper::toDto)
                .collect(toList());
    }

    public GenreDTO getById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(GENRE));
        return genreMapper.toDto(genre);
    }

    @Transactional
    public GenreDTO update(Long id, GenreRO genreRo) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with ID: " + id));

        genreMapper.updateFromPutRo(genreRo, genre);
        Genre updated = genreRepository.save(genre);
        log.info(MessageUtils.updateSuccess(GENRE));
        return genreMapper.toDto(updated);
    }

    @Transactional
    public GenreDTO patch(Long id, GenrePatchRO genreRo) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with ID: " + id));

        genreMapper.updateFromPatchRo(genreRo, genre);
        Genre updated = genreRepository.save(genre);
        log.info(MessageUtils.updateSuccess(GENRE));
        return genreMapper.toDto(genreRepository.save(updated));
    }

    @Transactional
    public void delete(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with ID: " + id));

        genreRepository.delete(genre);
        log.info(MessageUtils.deleteSuccess(GENRE));
    }
}