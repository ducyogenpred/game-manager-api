package com.firstgroup.gamemanagerapi.model.request;

public record ReviewPatchRO(
        String header,
        String content,
        double rating,
        long userId,
        long gameId
) {}
