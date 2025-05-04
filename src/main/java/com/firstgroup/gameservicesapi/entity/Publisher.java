package com.firstgroup.gameservicesapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "publisherID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GamePublisher> gamePublisher = new HashSet<>();
}
