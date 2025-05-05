package com.firstgroup.gamemanagerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;
}
