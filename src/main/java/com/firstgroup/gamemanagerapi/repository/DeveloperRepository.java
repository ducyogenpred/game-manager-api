package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    boolean existsByEmail(String email);
    boolean existsByName(String name);

    Optional<Developer> findByName(String name);
}
