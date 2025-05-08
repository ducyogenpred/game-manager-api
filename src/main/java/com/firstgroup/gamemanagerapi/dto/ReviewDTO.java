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
public class ReviewDTO {
    private long id;
    private String header;
    private String content;
    private  Double rating;
    private User user;
    private Game game;
}
