package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByTitleContainingIgnoreCase(String title);
    Optional<Game> findByTitleIgnoreCase(String title);
    List<Game> findByDeveloper_NameContainingIgnoreCase(String name);
    Optional<Game> findByDeveloper_NameIgnoreCase(String name);
    boolean existsGameByTitle(String title);
    boolean existsGameByDeveloper_Id(Long id);
    boolean existsGameByPublisher_Id(Long id);
    boolean existsGameByTitleAndDeveloper_IdAndPublisher_Id(String title, long developer_id, long publisher_id);
}
