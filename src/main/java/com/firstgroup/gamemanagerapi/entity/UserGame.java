package com.firstgroup.gamemanagerapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "users_games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGame implements Serializable {

    @EmbeddedId
    private UserGameId id;

    @Column(name = "purchased_at", nullable = false)
    private LocalDateTime purchasedAt;

    @Column(name = "hours_played")
    private Integer hoursPlayed;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id", nullable = false)
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
}