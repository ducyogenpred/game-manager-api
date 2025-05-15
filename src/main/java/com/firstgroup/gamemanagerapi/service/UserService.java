package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.AlreadyExistsException;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.UserDTO;
import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.model.mapper.UserMapper;
import com.firstgroup.gamemanagerapi.model.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.model.request.UserRO;
import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    public static final String USERS = "Users";
    public static final String USER = "User";

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional
    public UserDTO save(UserRO ro) {
        boolean emailExists = userRepository.existsByEmail(ro.email());
        boolean displayNameExists = userRepository.existsByDisplayName(ro.displayName());

        if (emailExists || displayNameExists) {
            List<ErrorResponse.FieldError> errors = getFieldErrors(ro, emailExists, displayNameExists);

            throw new AlreadyExistsException("User", errors);
        }

        User entity = userMapper.toEntity(ro);
        User saved = userRepository.save(entity);
        log.info(MessageUtils.saveSuccess(USER));
        return userMapper.toDto(saved);
    }

    private static List<ErrorResponse.FieldError> getFieldErrors(UserRO ro, boolean emailExists, boolean displayNameExists) {
        List<ErrorResponse.FieldError> errors = new ArrayList<>();

        if (emailExists) {
            errors.add(new ErrorResponse.FieldError(
                    "email",
                    "Email '" + ro.email() + "' already exists.",
                    ro.email()
            ));
        }

        if (displayNameExists) {
            errors.add(new ErrorResponse.FieldError(
                    "displayName",
                    "Display name '" + ro.displayName() + "' already exists.",
                    ro.displayName()
            ));
        }
        return errors;
    }

    public List<UserDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(USERS));
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(toList());
    }

    public UserDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(USER));
        return userMapper.toDto(user);
    }

    @Transactional
    public UserDTO update(Long id, UserRO ro) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        userMapper.updateFromPutRo(ro, user);
        User updated = userRepository.save(user);
        log.info(MessageUtils.updateSuccess(USER));
        return userMapper.toDto(updated);
    }

    @Transactional
    public UserDTO patch(Long id, UserPatchRO ro) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        userMapper.updateFromPatchRo(ro, user);
        User updated = userRepository.save(user);
        log.info(MessageUtils.updateSuccess(USER));
        return userMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        userRepository.delete(user);
        log.info(MessageUtils.deleteSuccess(USER));
    }
}
