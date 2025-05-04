package com.firstgroup.gameservicesapi.repository;

import com.firstgroup.gameservicesapi.entity.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGameRepository extends JpaRepository<UserGame, Long> {
}
