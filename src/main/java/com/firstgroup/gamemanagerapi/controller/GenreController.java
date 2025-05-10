package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.request.GenrePatchRO;
import com.firstgroup.gamemanagerapi.request.GenreRO;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import com.firstgroup.gamemanagerapi.service.GenreService;
import com.firstgroup.gamemanagerapi.entity.Genre;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.descriptor.java.ClockHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor

public class GenreController {

    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> createGenre (@Valid @RequestBody GenreRO ro) {
        log.info("Creating  with display name: {}", ro.displayName());
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
