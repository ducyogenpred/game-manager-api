package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import com.firstgroup.gamemanagerapi.service.UserService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRO ro) {
        log.info("Creating user with display name: {}", ro.displayName());
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(UserService.USERS),
                        userService.createUser(ro)
        ));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(UserService.USERS),
                        userService.getAll()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        log.info("Fetching user with ID: {}", id);
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
        }
    }

    @GetMapping("/display-name/{displayName}")
    public ResponseEntity<UserDTO> getUserByDisplayName(@PathVariable String displayName) {
        log.info("Fetching user with display name: {}", displayName);
        return ResponseEntity.ok(userService.getUserByDisplayName(displayName));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        log.info("Fetching user with email: {}", email);
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> patchUser(@PathVariable Long id, @Valid @RequestBody UserPatchRO ro) {
        log.info("Updating user with ID: {}", id);
        return ResponseEntity.ok(userService.patchUser(id, ro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("Deleting user with ID: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}