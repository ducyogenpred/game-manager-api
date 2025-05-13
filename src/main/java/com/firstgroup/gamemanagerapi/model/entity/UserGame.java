package com.firstgroup.gamemanagerapi.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users_games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "purchased_at", nullable = false)
    private LocalDateTime purchasedAt;

    @Column(name = "hours_played", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int hoursPlayed;

    @Column(name = "is_favorite", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean favourite;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    @JsonBackReference
    private Game game;

    @PrePersist
    protected void onCreate() {
        this.purchasedAt = LocalDateTime.now();
    }
}