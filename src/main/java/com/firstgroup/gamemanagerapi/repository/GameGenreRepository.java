package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.model.entity.GameGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameGenreRepository extends JpaRepository<GameGenre, Long> {
}
