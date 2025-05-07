package com.firstgroup.gamemanagerapi.dto;


import com.firstgroup.gamemanagerapi.entity.Game;
import com.firstgroup.gamemanagerapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteDTO {
    private Long id;
    private Game game;
    private User user;
}
