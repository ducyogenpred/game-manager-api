package com.firstgroup.gamemanagerapi.dto;

import com.firstgroup.gamemanagerapi.entity.UserGame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String displayName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String description;
}
