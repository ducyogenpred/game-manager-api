package com.firstgroup.gamemanagerapi.model.dto;

import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.entity.User;

import java.time.LocalDateTime;

public record UserGameDTO(
        long id,
        LocalDateTime purchasedAt,
        int hoursPlayed,
        boolean favourite,
        User user,
        Game game
) {}
