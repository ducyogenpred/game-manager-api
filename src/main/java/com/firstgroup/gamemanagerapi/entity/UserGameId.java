package com.firstgroup.gamemanagerapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserGameId implements Serializable {

    @Column(name = "user_id")
    private long userId;

    @Column(name = "game_id")
    private long gameId;
}
