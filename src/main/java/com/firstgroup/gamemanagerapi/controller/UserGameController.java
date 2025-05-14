package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.UserGameDTO;
import com.firstgroup.gamemanagerapi.model.request.UserGamePatchRO;
import com.firstgroup.gamemanagerapi.model.request.UserGameRO;
import com.firstgroup.gamemanagerapi.service.UserGameService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-game")
@RequiredArgsConstructor
public class UserGameController {

    private final UserGameService userGameService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid UserGameRO ro) {
        UserGameDTO entity = userGameService.save(ro);
        return ResponseEntity.ok(ResponseUtils.buildSuccessResponse(
                HttpStatus.OK,
                MessageUtils.saveSuccess(UserGameService.USER_GAME),
                entity));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<UserGameDTO> entities = userGameService.getAll();
        String message;

        if (entities.isEmpty()) {
            message = MessageUtils.retrieveEmpty(UserGameService.USER_GAMES);
        } else {
            message = MessageUtils.retrieveSuccess(UserGameService.USER_GAMES);
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
                        MessageUtils.retrieveSuccess(UserGameService.USER_GAME),
                        userGameService.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody @Valid UserGameRO ro
    ) {
        UserGameDTO entity = userGameService.update(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(UserGameService.USER_GAME),
                        entity
                )
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(
            @PathVariable Long id,
            @RequestBody @Valid UserGamePatchRO ro
    ) {
        UserGameDTO entity = userGameService.patch(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(UserGameService.USER_GAME),
                        entity
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
