package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Favorite;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);
    List<Favorite> findByGame(Game game);
    Optional<Favorite> findByUserAndGame(User user, Game game);
}
