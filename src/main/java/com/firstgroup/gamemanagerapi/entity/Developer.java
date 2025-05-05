package com.firstgroup.gamemanagerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String developerName;

    @Column(name = "description", nullable = false)
    private TextArea description;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "review_count", nullable = false)
    private Integer reviewCount;

    @Column(name = "rating_average", nullable = false)
    private Double ratingAverage;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "developerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Game> game = new HashSet<>();
}
