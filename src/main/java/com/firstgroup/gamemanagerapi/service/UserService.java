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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

            if (ro.firstName() != null) user.setFirstName(ro.firstName());
            if (ro.middleName() != null) user.setMiddleName(ro.middleName());
            if (ro.lastName() != null) user.setLastName(ro.lastName());
            if (ro.displayName() != null) user.setDisplayName(ro.displayName());
            if (ro.email() != null) user.setEmail(ro.email());
            if (ro.phoneNumber() != null) user.setPhoneNumber(ro.phoneNumber());
            if (ro.password() != null) user.setPassword(ro.password());
            if (ro.birthDate() != null) user.setBirthDate(ro.birthDate());
            if (ro.description() != null) user.setDescription(ro.description());

            user.setUpdatedAt(LocalDateTime.now());

            log.info(MessageUtils.updateSuccessMessage(USER));
            return userMapper.toDto(userRepository.save(user));

        } catch (Exception e) {
            String errorMessage = MessageUtils.updateErrorMessage(USER);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
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
