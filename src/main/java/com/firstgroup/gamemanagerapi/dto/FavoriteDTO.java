package com.firstgroup.gamemanagerapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FavoriteDTO {
    private long userId;
    private long gameId;

}
