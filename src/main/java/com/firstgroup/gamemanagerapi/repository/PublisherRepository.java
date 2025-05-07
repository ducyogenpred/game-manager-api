package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

    public interface PublisherRepository extendsp JpaRepository<Publisher, Long> {

    List<Publisher> findByNameContainingIgnoreCase(String name);
    Optional<Publisher> findByNameIgnoreCase(String name);
    List<Publisher> findByReviewCountGreaterThanEqual(Integer reviewCount);

}


