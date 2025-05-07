package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.FavoriteDTO;
import com.firstgroup.gamemanagerapi.request.FavoriteRO;
import com.firstgroup.gamemanagerapi.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping
    public ResponseEntity<FavoriteDTO> addToFavorites(@Valid @RequestBody FavoriteRO ro) {
        return ResponseEntity.ok(favoriteService.addToFavorite(ro));
    }

    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> getAllFavorites() {
        return ResponseEntity.ok(favoriteService.getAllFavorites());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavoriteById(@PathVariable long favoriteId) {
        favoriteService.deleteFavoriteById(favoriteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FavoriteDTO>> getFavoritesByUser(@PathVariable long userId) {
        return ResponseEntity.ok(favoriteService.getFavoritesByUser(userId));
    }
}
