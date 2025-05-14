package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.GenreDTO;
import com.firstgroup.gamemanagerapi.model.request.GenrePatchRO;
import com.firstgroup.gamemanagerapi.model.request.GenreRO;
import com.firstgroup.gamemanagerapi.service.GenreService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid GenreRO ro) {
        GenreDTO entity = genreService.save(ro);
        return ResponseEntity.ok(ResponseUtils.buildSuccessResponse(
                HttpStatus.OK,
                MessageUtils.saveSuccess(GenreService.GENRE),
                entity));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<GenreDTO> entities = genreService.getAll();
        String message;

        if (entities.isEmpty()) {
            message = MessageUtils.retrieveEmpty(GenreService.GENRES);
        } else {
            message = MessageUtils.retrieveSuccess(GenreService.GENRES);
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
                        MessageUtils.retrieveSuccess(GenreService.GENRE),
                        genreService.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody @Valid GenreRO ro
    ) {
        GenreDTO entity = genreService.update(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(GenreService.GENRE),
                        entity
                )
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(
            @PathVariable Long id,
            @RequestBody @Valid GenrePatchRO ro
    ) {
        GenreDTO entity = genreService.patch(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(GenreService.GENRE),
                        entity
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
