package com.firstgroup.gamemanagerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "gameId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserGame> userGames = new HashSet<>();

    @ManyToOne
    @MapsId("developerId")
    @JoinColumn(name = "developer_id", nullable = false)
    private Developer developerId;

    @ManyToOne
    @MapsId("publisherId")
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisherId;
}