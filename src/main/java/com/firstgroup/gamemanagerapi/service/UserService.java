package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.UserDTO;
import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.model.mapper.UserMapper;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.model.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.model.request.UserRO;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor()
public class UserService {

    public static final String USERS = "Users";

    public static final String USER = "User";

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Transactional
    public UserDTO createUser(@Valid UserRO ro) {
        try {
            User user = userMapper.toEntity(ro);
            user.setPassword(ro.password());

            User savedUser = userRepository.save(user);
            log.info(MessageUtils.saveSuccessMessage(USER));

            return userMapper.toDto(savedUser);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(MessageUtils.saveErrorMessage(USER));
        }
    }

    public List<UserDTO> getAll() {
        try {
            List<User> users = userRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(USERS));
            return users.stream().map(userMapper::toDto).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(USERS);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    public Optional<User> getById(Long id) {
        if (Objects.isNull(id)) {
            return Optional.empty();
        }

        return userRepository.findById(id);
    }

    public Optional<User> getByEmail(String email) {
        if (Objects.isNull(email)) {
            return Optional.empty();
        }

        return userRepository.findByEmail(email);
    }

    public Optional<User> getByDisplayName(String displayName) {
        if (Objects.isNull(displayName)) {
            return Optional.empty();
        }

        return userRepository.findByDisplayName(displayName);
    }

    public User getUserById(Long id) {
        try {
            Optional<User> user = getById(id);

            if (user.isEmpty()) {
                throw new Exception("User not found.");
            }
            log.info(MessageUtils.retrieveSuccessMessage(USER));
            return user.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(USER);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    public User getUserByEmail(String email) {
        try {
            Optional<User> user = getByEmail(email);

            if (user.isEmpty()) {
                throw new Exception("User not found.");
            }
            log.info(MessageUtils.retrieveSuccessMessage(USER));
            return user.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(USER);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    public User getUserByDisplayName(String displayName) {
        try {
            Optional<User> user = getByDisplayName(displayName);

            if (user.isEmpty()) {
                throw new Exception("User not found.");
            }
            log.info(MessageUtils.retrieveSuccessMessage(USER));
            return user.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(USER);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Transactional
    public UserDTO patchUser(Long id, @Valid UserPatchRO ro) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this ID does not exist."));

        if (ro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No fields provided for update.");
        }

        if (ro.displayName() != null && !ro.displayName().equals(user.getDisplayName())) {
            if (userRepository.existsByDisplayName(ro.displayName())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this display name already exists.");
            }
            user.setDisplayName(ro.displayName());
        }

        if (ro.email() != null && !ro.email().equals(user.getEmail())) {
            if (userRepository.existsByEmail(ro.email())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this email already exists.");
            }
            user.setEmail(ro.email());
        }

        userMapper.updateUserFromPatchRo(ro, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(Long id) {
        try {
            User user = getUserById(id);

            if (Objects.isNull(user)) {
                throw new ResourceNotFoundException("User not found");
            }

            userRepository.delete(user);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(USER);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}
