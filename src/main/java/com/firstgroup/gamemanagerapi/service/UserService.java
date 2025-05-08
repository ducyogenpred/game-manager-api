package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.mapper.UserMapper;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor()
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDTO createUser(@Valid UserRO ro) {
        if (userRepository.existsByDisplayName(ro.displayName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this display name already exists.");
        }

        if (userRepository.existsByEmail(ro.email())) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        User user = userMapper.toEntity(ro);

        user.setPassword(passwordEncoder.encode(ro.password()));

        try {
            User savedUser = userRepository.save(user);
            return userMapper.toDto(savedUser);
        } catch (DataIntegrityViolationException ex) {
            throw new IllegalArgumentException("User with this email or display name already exists.");
        }
    }

    public UserDTO getUserById(long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this ID does not exist.")));
    }

    public UserDTO getUserByDisplayName(String displayName) {
        return userMapper.toDto(userRepository.findByDisplayName(displayName)
                .orElseThrow(() -> new IllegalArgumentException("User with this display name does not exist.")));
    }

    public UserDTO getUserByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User with this email does not exist.")));
    }

    @Transactional
    public UserDTO patchUser(Long id, @Valid UserPatchRO ro) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with this id does not exist.")
        );

        if (ro.displayName().isPresent()) {
            String displayName = ro.displayName().get();
            if (!displayName.equals(user.getDisplayName()) &&
                    userRepository.existsByDisplayName(displayName)) {
                throw new IllegalArgumentException("User with this display name already exists.");
            }
            user.setDisplayName(displayName);
        }

        if (ro.email().isPresent()) {
            String email = ro.email().get();
            if (!email.equals(user.getEmail()) &&
                    userRepository.existsByEmail(email)) {
                throw new IllegalArgumentException("User with this email already exists.");
            }
            user.setEmail(email);
        }

        userMapper.updateUserFromPatchRo(ro, user);

        ro.password().ifPresent(password -> user.setPassword(passwordEncoder.encode(password)));

        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public Long deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with this id does not exist.")
        );

        userRepository.delete(user);
        return id;
    }
}
