package com.firstgroup.gamemanagerapi.controller;


import com.firstgroup.gamemanagerapi.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.request.PublisherRO;
import com.firstgroup.gamemanagerapi.service.PublisherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {


    private final PublisherService publisherService;


    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@Valid @RequestBody PublisherDTO ro) {
        return ResponseEntity.ok(publisherService.createPublisher(ro));
    }

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> findAllPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> findPublisherById(@PathVariable long id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    // Combined endpoint for both exact and partial name search
    @GetMapping("/search")
    public ResponseEntity<?> findPublishersByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "partial") String match // values: partial, exact
    ) {
        if ("exact".equalsIgnoreCase(match)) {
            return ResponseEntity.ok(publisherService.getPublisherByName(name));
        } else {
            return ResponseEntity.ok(publisherService.getPublishersByName(name));
        }
    }

    @GetMapping("/filter/review-count")
    public ResponseEntity<List<PublisherDTO>> findPublishersByReviewCount(@RequestParam int reviewCount) {
        return ResponseEntity.ok(publisherService.getPublishersByReviewCount(reviewCount));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherDTO> updatePublisher(
            @PathVariable long id,
            @Valid @RequestBody PublisherRO ro
    ) {
        return ResponseEntity.ok(publisherService.updatePublisher(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisherById(@PathVariable long id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.noContent().build();
    }
}