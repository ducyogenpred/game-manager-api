package com.firstgroup.gamemanagerapi.exception;

import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class AlreadyExistsException extends RuntimeException {
    private final List<ErrorResponse.FieldError> errors;

    public AlreadyExistsException(String entityType, List<ErrorResponse.FieldError> errors) {
        super(String.format("%s already exists with the following values: %s",
                entityType,
                errors.stream()
                        .map(e -> e.field() + "='" + e.value() + "'")
                        .toList()
        ));
        this.errors = errors;
    }
}
