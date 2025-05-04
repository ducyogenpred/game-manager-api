package com.firstgroup.gamemanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGameDTO {
    private long userId;
    private int gameId;
    private LocalDate purchasedDate;
    private String title;
}
