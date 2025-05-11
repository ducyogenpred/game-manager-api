package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
    boolean existsByName (String name);
    Optional<Genre> findByName(String name);
}
