package com.firstgroup.gamemanagerapi.model.dto;

public record ReviewDTO(
        long id,
        String title,
        String content,
        Double rating,
        long userId,
        long gameId
) {}
