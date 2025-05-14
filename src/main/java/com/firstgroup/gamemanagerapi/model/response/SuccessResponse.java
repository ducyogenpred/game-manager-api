package com.firstgroup.gamemanagerapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "statusCode", "message", "data"})
public class SuccessResponse<T> {
    boolean status = true;
    int statusCode;
    String message;
    T data;
}
