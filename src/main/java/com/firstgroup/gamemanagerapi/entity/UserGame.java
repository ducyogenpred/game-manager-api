package com.firstgroup.gamemanagerapi.entity;

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
@Builder
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "purchased_at", nullable = false)
    private LocalDateTime purchasedAt;

    @Column(name = "hours_played")
    private int hoursPlayed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    @JsonBackReference
    private Game game;

    @Override
    public String toString() {
        return "UserGame{" +
                "id=" + id +
                ", purchasedAt=" + purchasedAt +
                ", hoursPlayed=" + hoursPlayed +
                ", userId=" + user.getId() +
                ", userDisplayName=" + user.getDisplayName() +
                ", gameId=" + game.getId() +
                ", gameTitle=" + game.getTitle() +
                "}";
    }

    @PrePersist
    protected void onCreate() {
        this.purchasedAt = LocalDateTime.now();
    }
}