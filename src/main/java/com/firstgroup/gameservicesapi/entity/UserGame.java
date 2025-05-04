package com.firstgroup.gameservicesapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users_games")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGame {

    @EmbeddedId
    private UserGameId id;

    @Column(name = "purchased_at", nullable = false)
    private LocalDateTime purchasedAt;

    @Column(name = "hours_played")
    private Integer hoursPlayed;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;
}
