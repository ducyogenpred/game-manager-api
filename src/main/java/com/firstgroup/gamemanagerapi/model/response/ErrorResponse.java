package com.firstgroup.gamemanagerapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse<T> {
    boolean status = false;
    int statusCode;
    String message;
    T data;
}
