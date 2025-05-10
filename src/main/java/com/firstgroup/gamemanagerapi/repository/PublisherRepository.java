package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    boolean existsByName(String name);
    boolean existsByEmail (String email);
    Optional<Publisher> findByName (String name);
    Optional<Publisher> findByEmail(String email);
}