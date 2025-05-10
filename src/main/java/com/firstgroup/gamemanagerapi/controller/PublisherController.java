package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.request.PublisherRO;
import com.firstgroup.gamemanagerapi.service.PublisherService;
import com.firstgroup.gamemanagerapi.entity.Publisher;
import com.firstgroup.gamemanagerapi.request.PublisherPatchRO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher (@Valid @PathVariable PublisherRO ro) {
        PublisherDTO createdUser = publisherService.createPublisher(ro);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById (@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PublisherDTO> getPublisherByName (@PathVariable String name) {
        return ResponseEntity.ok(publisherService.getPublisherByName(name));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Publisher> patchPublisher (@PathVariable Long id, @Valid @RequestBody PublisherPatchRO ro) {
        return ResponseEntity.ok(publisherService.patchPublisher(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePublisher(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.deletePublisher(id));
    }
}
