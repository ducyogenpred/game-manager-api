package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.model.entity.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGameRepository extends JpaRepository<UserGame, Long> {
    boolean existsByUserIdAndGameId(Long userId, Long gameId);
}
