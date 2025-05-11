package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record ReviewPatchRO(
        @NotBlank(message = "Title must not be blank.")
        String title,

        @NotBlank(message = "Content must not be blank.")
        String content,

        @DecimalMin(value = "0.0", message = "Rating must be at least 0.")
        @DecimalMax(value = "5.0", message = "Rating must be at most 5.")
        Double rating
) {
    public boolean isEmpty() {
        return title == null && content == null && rating == null;
    }
}
