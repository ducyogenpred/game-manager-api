package com.firstgroup.gamemanagerapi.model.request;

import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record UserGamePatchRO(
        @PastOrPresent(message = "Purchase date must be in the past or present.")
        LocalDateTime purchaseAt,
        Boolean favourite
) {
    public boolean isEmpty() {
        return purchaseAt == null && favourite == null;
    }
}
