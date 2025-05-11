package com.firstgroup.gamemanagerapi.util;

import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.response.SuccessResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseUtils {

    public static <T> SuccessResponse<T> buildSuccessResponse(HttpStatus status, String message) {
        SuccessResponse<T> response = new SuccessResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);

        return response;
    }

    public static <T> SuccessResponse<T> buildSuccessResponse(HttpStatus status, String message, T data) {
        SuccessResponse<T> response = new SuccessResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public static <T> ErrorResponse<T> buildErrorResponse(HttpStatus status, String message) {
        ErrorResponse<T> response = new ErrorResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);

        return response;
    }

    public static <T> ErrorResponse<T> buildErrorResponse(HttpStatus status, String message, T data) {
        ErrorResponse<T> response = new ErrorResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);
        response.setData(data);

        return response;
    }

//    public static Object buildSuccessResponse(HttpStatus httpStatus, String s, List<UserDTO> all, UserDTO user) {
//        return null;
//    }
//
//    public static Object buildErrorResponse(HttpStatus httpStatus, String s, List<UserDTO> all, UserDTO user) {
//        return null;
//    }
}
