package com.firstgroup.gamemanagerapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> {
    boolean status = true;
    int statusCode;
    String message;
    T data;
}
