package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.model.request.GenrePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GenreRO;
import com.firstgroup.gamemanagerapi.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor

public class GenreController {

    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> createGenre (@Valid @RequestBody GenreRO ro) {
        log.info("Creating  with display name: {}", ro.name());
        return ResponseEntity.ok(genreService.createGenre(ro));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<GenreDTO> getGenreById (@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GenreDTO> patchGenre(@PathVariable Long id, @Valid @RequestBody GenrePatchRO ro) {
        log.info("Updating user with ID: {}", id);
        return ResponseEntity.ok(genreService.patchGenre(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        log.info("Deleting user with ID: {}", id);
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
