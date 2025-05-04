package com.firstgroup.gameservicesapi.controller;

import com.firstgroup.gameservicesapi.dto.UserDTO;
import com.firstgroup.gameservicesapi.request.UserRO;
import com.firstgroup.gameservicesapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserRO ro) {
        return ResponseEntity.ok(userService.createUser(ro));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable long id,
            @Valid @RequestBody UserRO ro) {
        return ResponseEntity.ok(userService.updateUser(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}