package com.firstgroup.gamemanagerapi.util;

import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.model.response.SuccessResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseUtils {

    public static <T> SuccessResponse<T> buildSuccessResponse(HttpStatus status, String message, T data) {
        return SuccessResponse.<T>builder()
                .statusCode(status.value())
                .message(message)
                .data(data)
                .build();
    }

    public static <T> SuccessResponse<T> buildSuccessResponse(HttpStatus status, String message) {
        return buildSuccessResponse(status, message, null);
    }

    public static <T> ErrorResponse<T> buildErrorResponse(HttpStatus status, String message, T data, List<ErrorResponse.FieldError> errors) {
        return ErrorResponse.<T>builder()
                .statusCode(status.value())
                .message(message)
                .data(data)
                .errors(errors)
                .build();
    }

    public static <T> ErrorResponse<T> buildErrorResponse(HttpStatus status, String message) {
        return buildErrorResponse(status, message, null, null);
    }

    public static <T> ErrorResponse<T> buildValidationErrorResponse(HttpStatus status, String message, List<ErrorResponse.FieldError> errors) {
        return buildErrorResponse(status, message, null, errors);
    }
}
