package com.firstgroup.gamemanagerapi.service.impl;

import com.firstgroup.gamemanagerapi.dto.FavoriteDTO;
import com.firstgroup.gamemanagerapi.entity.Favorite;
import com.firstgroup.gamemanagerapi.entity.Game;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.repository.FavoriteRepository;
import com.firstgroup.gamemanagerapi.repository.GameRepository;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository,
                               UserRepository userRepository,
                               GameRepository gameRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public FavoriteDTO addFavorite(Long userId, Long gameId) {
        // Check if already a favorite
        if (favoriteRepository.existsByUserIdAndGameId(userId, gameId)) {
            throw new RuntimeException("Game is already in favorites");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        Favorite favorite = Favorite.builder()
                .user(user)
                .game(game)
                .createdAt(java.time.LocalDateTime.now())
                .build();

        Favorite savedFavorite = favoriteRepository.save(favorite);
        return convertToDTO(savedFavorite);
    }

    @Override
    public List<FavoriteDTO> getFavoritesByUserId(Long userId) {
        List<Favorite> favorites = favoriteRepository.findByUserId(userId);
        return favorites.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isFavorite(Long userId, Long gameId) {
        return favoriteRepository.existsByUserIdAndGameId(userId, gameId);
    }

    @Override
    @Transactional
    public void removeFavorite(Long userId, Long gameId) {
        favoriteRepository.deleteByUserIdAndGameId(userId, gameId);
    }

    @Override
    @Transactional
    public void removeFavoriteById(Long id) {
        favoriteRepository.deleteById(id);
    }

    private FavoriteDTO convertToDTO(Favorite favorite) {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setId(favorite.getId());
        dto.setUserId(favorite.getUser().getId());
        dto.setGameId(favorite.getGame().getId());
        dto.setGameName(favorite.getGame().getName());
        dto.setGameDescription(favorite.getGame().getDescription());
        dto.setCreatedAt(favorite.getCreatedAt());
        return dto;
    }