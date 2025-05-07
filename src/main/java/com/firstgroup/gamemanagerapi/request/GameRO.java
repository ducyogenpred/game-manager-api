    package com.firstgroup.gamemanagerapi.request;

    import com.firstgroup.gamemanagerapi.entity.Developer;
    import com.firstgroup.gamemanagerapi.entity.Publisher;
    import jakarta.validation.constraints.NotBlank;
    import lombok.Data;

    import java.time.LocalDate;

    public record GameRO(
            @NotBlank String title,
            @NotBlank String description,
            @NotBlank LocalDate releaseDate,
            @NotBlank Publisher publisher,
            @NotBlank Developer developer
    ) {}
