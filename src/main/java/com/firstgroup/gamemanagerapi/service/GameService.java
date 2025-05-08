package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.GameDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.entity.Game;
import com.firstgroup.gamemanagerapi.entity.Publisher;
import com.firstgroup.gamemanagerapi.mapper.GameMapper;
import com.firstgroup.gamemanagerapi.repository.DeveloperRepository;
import com.firstgroup.gamemanagerapi.repository.GameRepository;
import com.firstgroup.gamemanagerapi.repository.PublisherRepository;
import com.firstgroup.gamemanagerapi.request.GameRO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;
    private final GameMapper gameMapper;

    public Game createGame(@Valid GameRO ro) {

        Developer developer = developerRepository.findById(ro.developerId())
                .orElseThrow(() -> new EntityNotFoundException("Developer not found"));

        Publisher publisher = publisherRepository.findById(ro.publisherId())
                .orElseThrow(() -> new EntityNotFoundException("Publisher not found"));

        if (gameRepository.existsGameByTitleAndDeveloper_IdAndPublisher_Id(
                ro.title(), ro.developer().getId(), ro.publisher().getId())) {
            throw new IllegalStateException("Game with the same title, developer, and publisher already exists.");
        }

        Game game = new Game();
        game.setTitle(ro.title());
        game.setDescription(ro.description());
        game.setReleaseDate(ro.releaseDate());
        game.setDeveloper(ro.developer());
        game.setPublisher(ro.publisher());

        return gameRepository.save(game);
    }

    public List<GameDTO> getAllGames() {
        return gameRepository.findAll()
                .stream()
                .map(gameMapper::toDto)
                .toList();
    }

    public GameDTO getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game with id " + id + " not found!"));
        return gameMapper.toDto(game);
    }

    public List<GameDTO> getGamesByTitle(String title) {
        return gameRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(gameMapper::toDto)
                .toList();
    }

    public GameDTO getGameByTitle(String title) {
        Game game = gameRepository.findByTitleIgnoreCase(title)
                .orElseThrow(() -> new EntityNotFoundException(title + " not found!"));
        return gameMapper.toDto(game);
    }
}
