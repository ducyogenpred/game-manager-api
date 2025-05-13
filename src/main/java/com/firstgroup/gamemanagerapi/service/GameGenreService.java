package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.GameGenreDTO;
import com.firstgroup.gamemanagerapi.model.entity.GameGenre;
import com.firstgroup.gamemanagerapi.model.mapper.GameGenreMapper;
import com.firstgroup.gamemanagerapi.model.request.GameGenreRO;
import com.firstgroup.gamemanagerapi.repository.GameGenreRepository;
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
public class GameGenreService {

    public static final String GAME_GENRES = "Game Genres";
    public static final String GAME_GENRE = "Game Genre";

    private final GameGenreRepository gameGenreRepository;
    private final GameGenreMapper gameGenreMapper;

    @Transactional
    public GameGenreDTO save(GameGenreRO ro) {
        GameGenre entity = gameGenreMapper.toEntity(ro);
        GameGenre saved = gameGenreRepository.save(entity);
        log.info(MessageUtils.saveSuccess(GAME_GENRE));
        return gameGenreMapper.toDto(saved);
    }

    public List<GameGenreDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(GAME_GENRES));
        return gameGenreRepository.findAll().stream()
                .map(gameGenreMapper::toDto)
                .collect(toList());
    }

    public GameGenreDTO getById(Long id) {
        GameGenre genre = gameGenreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game genre not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(GAME_GENRE));
        return gameGenreMapper.toDto(genre);
    }

    @Transactional
    public void delete(Long id) {
        GameGenre genre = gameGenreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game genre not found with ID: " + id));

        gameGenreRepository.delete(genre);
        log.info(MessageUtils.deleteSuccess(GAME_GENRE));
    }
}
