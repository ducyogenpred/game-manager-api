package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByDisplayName(String displayName);
    boolean existsByEmail(String email);
}
