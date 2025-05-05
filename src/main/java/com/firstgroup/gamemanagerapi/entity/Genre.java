package com.firstgroup.gamemanagerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "genreId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Game> genreGames;
}
