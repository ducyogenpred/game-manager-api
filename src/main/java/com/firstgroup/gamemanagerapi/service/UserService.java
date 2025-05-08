package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.mapper.UserMapper;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor()
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public User createUser(@Valid UserRO ro) {
        if (userRepository.existsByDisplayName(ro.displayName())) {
            throw new IllegalArgumentException("User with this display name already exists.");
        }

        if (userRepository.existsByEmail(ro.email())) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        return userRepository.save(userMapper.toEntity(ro));
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with this id does not exist."));
    }

    public User getUserByDisplayName(String displayName) {
        return userRepository.findByDisplayName(displayName).orElseThrow(() -> new IllegalArgumentException("User with this display name does not exist."));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User with this email does not exist."));
    }

    @Transactional
    public User patchUser(Long id, @Valid UserPatchRO ro) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with this id does not exist.")
        );

        if (ro.displayName().isPresent()) {
            String displayName = ro.displayName().get();
            if (userRepository.existsByDisplayName(displayName)) {
                throw new IllegalArgumentException("User with this display name already exists.");
            }
            user.setDisplayName(displayName);
        }

        if (ro.email().isPresent()) {
            String email = ro.email().get();
            if (userRepository.existsByDisplayName(email)) {
                throw new IllegalArgumentException("User with this email already exists.");
            }
            user.setEmail(email);
        }

        ro.firstName().ifPresent(user::setFirstName);
        ro.middleName().ifPresent(user::setMiddleName);
        ro.lastName().ifPresent(user::setLastName);
        ro.phoneNumber().ifPresent(user::setPhoneNumber);
        ro.password().ifPresent(user::setPassword);
        ro.birthDate().ifPresent(user::setBirthDate);
        ro.description().ifPresent(user::setDescription);

        return userRepository.save(user);
    }

    @Transactional
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with this id does not exist.")
        );

        userRepository.delete(user);
        return user;
    }
}
