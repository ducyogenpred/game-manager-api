package com.firstgroup.gamemanagerapi.dto;

import com.firstgroup.gamemanagerapi.entity.Game;
import com.firstgroup.gamemanagerapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGameDTO {
    private long id;
    private LocalDateTime purchasedAt;
    private int hoursPlayed;
    boolean isFavorite;
    private User user;
    private Game game;
}
