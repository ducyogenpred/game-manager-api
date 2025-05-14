package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.GameDTO;
import com.firstgroup.gamemanagerapi.model.request.GamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GameRO;
import com.firstgroup.gamemanagerapi.service.GameService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid GameRO ro) {
        GameDTO entity = gameService.save(ro);
        return ResponseEntity.ok(ResponseUtils.buildSuccessResponse(
                HttpStatus.OK,
                MessageUtils.saveSuccess(GameService.GAME),
                entity));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<GameDTO> entities = gameService.getAll();
        String message;

        if (entities.isEmpty()) {
            message = MessageUtils.retrieveEmpty(GameService.GAMES);
        } else {
            message = MessageUtils.retrieveSuccess(GameService.GAMES);
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
                        MessageUtils.retrieveSuccess(GameService.GAME),
                        gameService.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody @Valid GameRO ro
    ) {
        GameDTO entity = gameService.update(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(GameService.GAME),
                        entity
                )
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(
            @PathVariable Long id,
            @RequestBody @Valid GamePatchRO ro
    ) {
        GameDTO entity = gameService.patch(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(GameService.GAME),
                        entity
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}