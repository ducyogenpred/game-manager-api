package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsAllByHeader(String header);
    boolean existsByHeader(String header);
    boolean existsAllByHeaderIgnoreCase(String header);
    boolean existsByHeaderIgnoreCase(String header);
    Boolean findAllByHeader(String header);
    Optional<Review> findByHeader(String header);

}
