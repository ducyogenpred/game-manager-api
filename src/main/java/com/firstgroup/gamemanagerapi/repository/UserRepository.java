package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByDisplayName(String displayName);
    boolean existsByEmail(String email);
    Optional<User> findByDisplayName(String displayName);
    Optional<User> findByEmail(String email);
}
