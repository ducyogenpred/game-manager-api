package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsByUserIdAndGameId(Long userId, Long reviewId);
}
