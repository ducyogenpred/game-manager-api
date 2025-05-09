package com.firstgroup.gamemanagerapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "games_genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonBackReference
    private Genre genre;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "game_id")
    private Game game;
}
