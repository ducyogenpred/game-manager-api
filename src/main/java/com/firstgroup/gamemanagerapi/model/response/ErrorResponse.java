package com.firstgroup.gamemanagerapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "statusCode", "message", "data", "errors"})
public class ErrorResponse<T> {
    boolean status = false;
    int statusCode;
    String message;
    T data;
    List<FieldError> errors;

    public record FieldError(String field, String message, String value) {}
}
