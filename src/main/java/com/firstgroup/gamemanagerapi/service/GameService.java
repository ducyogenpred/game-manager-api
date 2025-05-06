package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.GameDTO;
import com.firstgroup.gamemanagerapi.entity.Game;
import com.firstgroup.gamemanagerapi.mapper.GameMapper;
import com.firstgroup.gamemanagerapi.repository.GameRepository;
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
    private final GameMapper gameMapper;

    public Game createGame(@Valid GameRO ro) {
        if (gameRepository.)
    }

    public List<GameDTO> getAllGames() {
        return gameRepository.findAll()
                .stream()
                .map(gameMapper::toDto)
                .toList();
    }

    public GameDTO getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found!"));
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
                .orElseThrow(() -> new EntityNotFoundException("User with title " + title + " not found!"));
        return gameMapper.toDto(game);
    }

    public List<GameDTO> getGamesByDeveloper(String developer) {
        return gameRepository.findByDeveloper_NameContainingIgnoreCase(developer)
                .stream()
                .map(gameMapper::toDto)
                .toList();
    }

    public GameDTO getGameByDeveloper(String developer) {
        Game game = gameRepository.findByDeveloper_NameIgnoreCase(developer)
                .orElseThrow(() -> new EntityNotFoundException("User with developer " + developer + " not found!"));
        return gameMapper.toDto(game);
    }
}
