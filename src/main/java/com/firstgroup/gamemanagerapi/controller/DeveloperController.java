package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.service.DeveloperService;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.request.DeveloperPatchRO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping
    public ResponseEntity<DeveloperDTO> createDeveloper (@Valid @RequestBody DeveloperRO ro) {
        DeveloperDTO createdUser = developerService.createDeveloper(ro);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> getDeveloperById (@PathVariable Long id) {
        return ResponseEntity.ok(developerService.getDeveloperById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DeveloperDTO> getDeveloperByName (@PathVariable String name) {
        return ResponseEntity.ok(developerService.getDeveloperByName(name));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Developer> patchDeveloper (@PathVariable Long id, @Valid @RequestBody DeveloperPatchRO ro) {
        return ResponseEntity.ok(developerService.patchDeveloper(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDeveloper (@PathVariable Long id) {
        return ResponseEntity.ok(developerService.deleteDeveloper(id));
    }
}
