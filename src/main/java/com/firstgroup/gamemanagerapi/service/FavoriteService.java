package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.FavoriteDTO;
import com.firstgroup.gamemanagerapi.entity.Favorite;
import com.firstgroup.gamemanagerapi.mapper.FavoriteMapper;
import com.firstgroup.gamemanagerapi.repository.FavoriteRepository;
import com.firstgroup.gamemanagerapi.request.FavoriteRO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.entity.Game;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.repository.GameRepository;




import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final FavoriteMapper favoriteMapper;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public FavoriteDTO addToFavorite(@Valid FavoriteRO favoriteRO) {

        Optional <User> userOpt = userRepository.findById(favoriteRO.userId());
        Optional <Game> gameOpt = gameRepository.findById(favoriteRO.gameId());

        if(userOpt.isPresent() && gameOpt.isPresent()) {
            User user = userOpt.get();
            Game game = gameOpt.get();

            Favorite favorite = new Favorite();
            favorite.setUser(user);
            favorite.setGame(game);

            Favorite savedFavorite = favoriteRepository.save(favorite);

            return favoriteMapper.toDto(savedFavorite);

        } else {
            throw new EntityNotFoundException("User or Game does not exist!");
        }

    }

    public List<FavoriteDTO> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream()
                .map(favoriteMapper::toDto)
                .toList();
    }

    public void deleteFavoriteById(long favoriteId) {
        if(!favoriteRepository.existsById(favoriteId)) {
            throw new EntityNotFoundException(favoriteId + "does not exist.");
        }
        favoriteRepository.deleteById(favoriteId);
    }

    public List<FavoriteDTO> getFavoritesByUser(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));

        List<Favorite> favorites = favoriteRepository.findByUser(user);
        return favorites.stream()
                .map(favoriteMapper::toDto)
                .toList();


    }

}

