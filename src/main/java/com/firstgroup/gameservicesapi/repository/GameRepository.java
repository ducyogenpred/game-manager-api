package com.firstgroup.gameservicesapi.repository;

import com.firstgroup.gameservicesapi.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
