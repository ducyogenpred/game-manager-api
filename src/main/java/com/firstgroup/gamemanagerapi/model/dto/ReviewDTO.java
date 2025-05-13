package com.firstgroup.gamemanagerapi.model.dto;

import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.entity.User;

public record ReviewDTO(
        long id,
        String title,
        String content,
        Double rating,
        User user,
        Game game
) {}
