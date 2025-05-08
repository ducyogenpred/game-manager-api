package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import com.firstgroup.gamemanagerapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserRO ro) {
        return ResponseEntity.ok(userService.createUser(ro));
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to Game Manager API!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(userService.getUserById(id));
    }

    @GetMapping("/display-name/{displayName}")
    public ResponseEntity<UserDTO> getUserByDisplayName(@PathVariable String displayName) {
        return ResponseEntity.ok(userService.getUserByDisplayName(displayName));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Long id, @Valid @RequestBody UserPatchRO ro) {
        return ResponseEntity.ok(userService.patchUser(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}