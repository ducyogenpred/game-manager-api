package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.model.request.DeveloperPatchRO;
import com.firstgroup.gamemanagerapi.model.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.service.DeveloperService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developer")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid DeveloperRO ro) {
        DeveloperDTO entity = developerService.save(ro);
        return ResponseEntity.ok(ResponseUtils.buildSuccessResponse(
                HttpStatus.OK,
                MessageUtils.saveSuccess(DeveloperService.DEVELOPER),
                entity));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<DeveloperDTO> entities = developerService.getAll();
        String message;

        if (entities.isEmpty()) {
            message = MessageUtils.retrieveEmpty(DeveloperService.DEVELOPERS);
        } else {
            message = MessageUtils.retrieveSuccess(DeveloperService.DEVELOPERS);
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
                        MessageUtils.retrieveSuccess(DeveloperService.DEVELOPER),
                        developerService.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody @Valid DeveloperRO ro
    ) {
        DeveloperDTO entity = developerService.update(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(DeveloperService.DEVELOPER),
                        entity
                )
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(
            @PathVariable Long id,
            @RequestBody @Valid DeveloperPatchRO ro
    ) {
        DeveloperDTO entity = developerService.patch(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(DeveloperService.DEVELOPER),
                        entity
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        developerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}