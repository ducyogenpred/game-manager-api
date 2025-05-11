package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.model.request.PublisherRO;
import com.firstgroup.gamemanagerapi.service.PublisherService;
import com.firstgroup.gamemanagerapi.model.request.PublisherPatchRO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher (@Valid @RequestBody PublisherRO ro) {
        return ResponseEntity.ok(publisherService.createPublisher(ro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById (@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PublisherDTO> getPublisherByName (@PathVariable String name) {
        return ResponseEntity.ok(publisherService.getPublisherByName(name));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PublisherDTO> getPublisherByEmail (@PathVariable String email) {
        return ResponseEntity.ok(publisherService.getPublisherByEmail(email));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PublisherDTO> patchPublisher (@PathVariable Long id, @Valid @RequestBody PublisherPatchRO ro) {
        return ResponseEntity.ok(publisherService.patchPublisher(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
}
