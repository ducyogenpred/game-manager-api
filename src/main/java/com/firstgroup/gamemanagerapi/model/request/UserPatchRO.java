package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserPatchRO(
        @Pattern(regexp = "^\\p{IsAlphabetic}(?:[\\p{IsAlphabetic} '-]*|(?: \\p{IsAlphabetic}[\\p{IsAlphabetic} '-]*)*)(?<! )$",
                message = "First name must start with a letter and may contain letters, spaces, hyphens, or apostrophes.")
        String firstName,

        @Pattern(regexp = "^\\p{IsAlphabetic}(?:[\\p{IsAlphabetic} '-]*|(?: \\p{IsAlphabetic}[\\p{IsAlphabetic} '-]*)*)(?<! )$",
                message = "Middle name must start with a letter and may contain letters, spaces, hyphens, or apostrophes.")
        String middleName,

        @Pattern(regexp = "^\\p{IsAlphabetic}(?:[\\p{IsAlphabetic} '-]*|(?: \\p{IsAlphabetic}[\\p{IsAlphabetic} '-]*)*)(?<! )$",
                message = "Last name must start with a letter and may contain letters, spaces, hyphens, or apostrophes.")
        String lastName,

        @Size(min = 4, message = "Display name must have at least 4 characters.")
        @Pattern(regexp = "^\\S.*$", message = "Display name must not start with a space.")
        String displayName,

        @Email(message = "Email must be a valid email address.")
        String email,

        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must have 10-15 digits.")
        String phoneNumber,

        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}",
                message = "Password must include 1 digit, 1 lowercase, 1 uppercase, and 1 special character.")
        String password,

        @Past(message = "Birthdate must be in the past.")
        LocalDate birthDate,

        @Pattern(regexp = "^\\S.*$", message = "Description must not start with a space.")
        String description
) {
    public boolean isEmpty() {
        return firstName == null && middleName == null && lastName == null &&
                displayName == null && email == null && phoneNumber == null &&
                password == null && birthDate == null && description == null;
    }
}