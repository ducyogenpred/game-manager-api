package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Optional<Developer> findDeveloperById(Long id);
}
