package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.FavoriteDTO;
import com.firstgroup.gamemanagerapi.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<FavoriteDTO> addFavorite(@RequestBody Map<String, Long> payload) {
        Long userId = payload.get("userId");
        Long gameId = payload.get("gameId");

        if (userId == null || gameId == null) {
            return ResponseEntity.badRequest().build();
        }

        FavoriteDTO favoriteDTO = favoriteService.addFavorite(userId, gameId);
        return new ResponseEntity<>(favoriteDTO, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FavoriteDTO>> getUserFavorites(@PathVariable Long userId) {
        List<FavoriteDTO> favorites = favoriteService.getFavoritesByUserId(userId);
        return ResponseEntity.ok(favorites);
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkFavorite(@RequestParam Long userId, @RequestParam Long gameId) {
        boolean isFavorite = favoriteService.isFavorite(userId, gameId);
        return ResponseEntity.ok(isFavorite);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeFavorite(@RequestParam Long userId, @RequestParam Long gameId) {
        favoriteService.removeFavorite(userId, gameId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFavoriteById(@PathVariable Long id) {
        favoriteService.removeFavoriteById(id);
        return ResponseEntity.noContent().build();
    }
}