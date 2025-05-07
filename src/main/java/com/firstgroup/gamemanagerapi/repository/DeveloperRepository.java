package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    boolean existsByEmail(String email);
    List<Developer> findByNameContainingIgnoreCase(String name);
    Optional<Developer> findByNameIgnoreCase(String name);
    List<Developer> findByReviewCountGreaterThanEqual(Integer reviewCount);
    Optional<Developer> findByRatingAverageDesc();
}
