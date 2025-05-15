package com.firstgroup.gamemanagerapi.controller;

import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.service.LoginService;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User login) {
        User user = loginService.login(login.getDisplayName(), login.getPassword());

        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                HttpStatus.OK,
                MessageUtils.retrieveSuccess("USER"),
                user
                )
        );
    }
}
