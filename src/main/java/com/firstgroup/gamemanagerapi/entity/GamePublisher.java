package com.firstgroup.gameservicesapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "games_publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GamePublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @MapsId("gameID")
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;

    @ManyToOne
    @MapsId("publisherID")
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisherID;
}