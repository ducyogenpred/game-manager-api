package com.firstgroup.gameservicesapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishers")
@Data
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
    private TextArea descripition;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "review_count", nullable = false)
    private Integer reviewCount;

    @Column(name = "rating_average", nullable = false)
    private Double ratingAverage;

    @Column(name = "created_at", nullable = false)

    @OneToMany(mappedBy = "publisherID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Game> game = new HashSet<>();
}
