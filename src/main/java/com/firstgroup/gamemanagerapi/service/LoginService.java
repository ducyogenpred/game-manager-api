package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(String displayName, String password) {
        User user = userRepository.findByDisplayName(displayName)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with display name " + displayName));

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid Credentials");
        }

        log.info(MessageUtils.retrieveSuccess("USER"));
        return user;
    }
}
