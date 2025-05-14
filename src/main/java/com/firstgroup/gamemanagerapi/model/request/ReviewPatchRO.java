package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.*;

public record ReviewPatchRO(
        @Pattern(regexp = "^\\S.*$", message = "Title must not start with a space.")
        String title,

        @Pattern(regexp = "^\\S.*$", message = "Content must not start with a space.")
        String content,

        @Min(value = 1, message = "Rating must be at least 1")
        @Max(value = 5, message = "Rating must be at most 5")
        Integer rating
) {
    public boolean isEmpty() {
        return title == null && content == null && rating == null;
    }
}
