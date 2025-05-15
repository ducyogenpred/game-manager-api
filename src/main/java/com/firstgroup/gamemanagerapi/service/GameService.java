package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.GameDTO;
import com.firstgroup.gamemanagerapi.model.entity.Developer;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.entity.Publisher;
import com.firstgroup.gamemanagerapi.model.mapper.GameMapper;
import com.firstgroup.gamemanagerapi.model.request.GamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GameRO;
import com.firstgroup.gamemanagerapi.repository.DeveloperRepository;
import com.firstgroup.gamemanagerapi.repository.GameRepository;
import com.firstgroup.gamemanagerapi.repository.PublisherRepository;
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
public class GameService {

    public static final String GAMES = "Games";
    public static final String GAME = "Game";

    private final GameRepository gameRepository;
    private final PublisherRepository publisherRepository;
    private final DeveloperRepository developerRepository;

    private final GameMapper gameMapper;

    @Transactional
    public GameDTO save(GameRO ro) {
        Publisher publisher = publisherRepository.findById(ro.publisherId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));

        Developer developer = developerRepository.findById(ro.developerId())
                .orElseThrow(() -> new ResourceNotFoundException("Developer not found"));

        Game entity = gameMapper.toEntity(ro, publisher, developer);
        Game saved = gameRepository.save(entity);
        log.info(MessageUtils.saveSuccess(GAME));
        return gameMapper.toDto(saved);
    }

    public List<GameDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(GAMES));
        return gameRepository.findAll().stream()
                .map(gameMapper::toDto)
                .collect(toList());
    }

    public GameDTO getById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(GAME));
        return gameMapper.toDto(game);
    }

    @Transactional
    public GameDTO update(Long id, GameRO ro) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + id));

        Publisher publisher = publisherRepository.findById(ro.publisherId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));

        Developer developer = developerRepository.findById(ro.developerId())
                .orElseThrow(() -> new ResourceNotFoundException("Developer not found"));

        gameMapper.updateFromPutRo(ro, game, publisher, developer);
        Game updated = gameRepository.save(game);
        log.info(MessageUtils.updateSuccess(GAME));
        return gameMapper.toDto(updated);
    }

    @Transactional
    public GameDTO patch(Long id, GamePatchRO ro) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + id));

        if (ro.publisherId() != null) {
            Publisher publisher = publisherRepository.findById(ro.publisherId())
                    .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));
            game.setPublisher(publisher);
        }

        if (ro.developerId() != null) {
            Developer developer = developerRepository.findById(ro.developerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Developer not found"));
            game.setDeveloper(developer);
        }

        gameMapper.updateFromPatchRo(ro, game);
        Game updated = gameRepository.save(game);
        log.info(MessageUtils.updateSuccess(GAME));
        return gameMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with ID: " + id));

        gameRepository.delete(game);
        log.info(MessageUtils.deleteSuccess(GAME));
    }
}
