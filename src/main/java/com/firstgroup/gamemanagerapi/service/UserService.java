package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.mapper.UserMapper;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
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
        User user = userMapper.toEntity(ro);
        user.setPassword(ro.password());

        try {
            User savedUser = userRepository.save(user);
            return userMapper.toDto(savedUser);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this display name or email already exists.");
        }
    }

//    public List<UserDTO> getAll() {
//        try {
//            List<User> users = userRepository.findAll();
//            log.info(MessageUtils.retrieveSuccessMessage(USERS));
//            return users.stream().map(userMapper::toDto).toList();
//        } catch (Exception e) {
//            String errorMessage = MessageUtils.retrieveErrorMessage(USERS);
//            log.error(errorMessage);
//            throw new ServiceException(errorMessage, e);
//        }
//    }

    public UserDTO getUserById(long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this ID does not exist.")));
    }

    public UserDTO getUserByDisplayName(String displayName) {
        return userMapper.toDto(userRepository.findByDisplayName(displayName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this display name does not exist.")));
    }

    public UserDTO getUserByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this email does not exist.")));
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
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this ID does not exist."));
        userRepository.delete(user);
    }
}
