package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.FavoriteDTO;

import java.util.List;

public interface FavoriteService {

    FavoriteDTO addFavorite(Long userId, Long gameId);

    List<FavoriteDTO> getFavoritesByUserId(Long userId);

    boolean isFavorite(Long userId, Long gameId);

    void removeFavorite(Long userId, Long gameId);

    void removeFavoriteById(Long id);
}