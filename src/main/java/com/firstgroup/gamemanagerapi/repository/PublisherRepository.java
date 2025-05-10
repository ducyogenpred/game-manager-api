package com.firstgroup.gamemanagerapi.repository;

import com.firstgroup.gamemanagerapi.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    boolean existsByEmail (String email);
    boolean existsByName (String name);

    Optional<Publisher> findByName (String name);

}


