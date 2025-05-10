package com.firstgroup.gamemanagerapi.dto;

import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {
    private long id;
    private String title;
    private String description;
    private LocalDateTime releaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Publisher publisher;
    private Developer developer;
}
