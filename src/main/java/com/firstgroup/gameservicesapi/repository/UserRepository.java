package com.firstgroup.gameservicesapi.repository;

import com.firstgroup.gameservicesapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);
    boolean existsByDisplayName(String username);
    boolean existsByEmail(String email);
}
