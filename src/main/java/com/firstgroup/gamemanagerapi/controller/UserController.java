package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import com.firstgroup.gamemanagerapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Create User
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserRO ro) {
        UserDTO createdUser = userService.createUser(ro);
        return ResponseEntity.ok(createdUser);  // Or use `ResponseEntity.status(HttpStatus.CREATED).body(createdUser);`
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Get user by display name
    @GetMapping("/display-name/{displayName}")
    public ResponseEntity<UserDTO> getUserByDisplayName(@PathVariable String displayName) {
        return ResponseEntity.ok(userService.getUserByDisplayName(displayName));
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    // Patch (update) user
    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Long id, @Valid @RequestBody UserPatchRO ro) {
        return ResponseEntity.ok(userService.patchUser(id, ro));
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}