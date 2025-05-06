package com.firstgroup.gamemanagerapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String publisherName;

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

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Game> game;
}