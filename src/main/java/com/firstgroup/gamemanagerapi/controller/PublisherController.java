package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.model.request.PublisherPatchRO;
import com.firstgroup.gamemanagerapi.model.request.PublisherRO;
import com.firstgroup.gamemanagerapi.service.PublisherService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid PublisherRO ro) {
        PublisherDTO entity = publisherService.save(ro);
        return ResponseEntity.ok(ResponseUtils.buildSuccessResponse(
                HttpStatus.OK,
                MessageUtils.saveSuccess(PublisherService.PUBLISHER),
                entity));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<PublisherDTO> entities = publisherService.getAll();
        String message;

        if (entities.isEmpty()) {
            message = MessageUtils.retrieveEmpty(PublisherService.PUBLISHERS);
        } else {
            message = MessageUtils.retrieveSuccess(PublisherService.PUBLISHERS);
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
                        MessageUtils.retrieveSuccess(PublisherService.PUBLISHER),
                        publisherService.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody @Valid PublisherRO ro
    ) {
        PublisherDTO entity = publisherService.update(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(PublisherService.PUBLISHER),
                        entity
                )
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(
            @PathVariable Long id,
            @RequestBody @Valid PublisherPatchRO ro
    ) {
        PublisherDTO entity = publisherService.patch(id, ro);
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.updateSuccess(PublisherService.PUBLISHER),
                        entity
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        publisherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}