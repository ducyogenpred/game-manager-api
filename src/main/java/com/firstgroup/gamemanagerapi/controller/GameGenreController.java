package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.GameGenreDTO;
import com.firstgroup.gamemanagerapi.model.request.GameGenreRO;
import com.firstgroup.gamemanagerapi.service.GameGenreService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game-genre")
@RequiredArgsConstructor
public class GameGenreController {

    private final GameGenreService gameGenreService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid GameGenreRO ro) {
        GameGenreDTO entity = gameGenreService.save(ro);
        return ResponseEntity.ok(ResponseUtils.buildSuccessResponse(
                HttpStatus.OK,
                MessageUtils.saveSuccess(GameGenreService.GAME_GENRE),
                entity));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<GameGenreDTO> entities = gameGenreService.getAll();
        String message;

        if (entities.isEmpty()) {
            message = MessageUtils.retrieveEmpty(GameGenreService.GAME_GENRES);
        } else {
            message = MessageUtils.retrieveSuccess(GameGenreService.GAME_GENRES);
        }

        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        message,
                        entities
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccess(GameGenreService.GAME_GENRE),
                        gameGenreService.getById(id)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        gameGenreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
