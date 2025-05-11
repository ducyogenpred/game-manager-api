package com.firstgroup.gamemanagerapi.exception.handler;

import com.firstgroup.gamemanagerapi.exception.ServiceException;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.exception.DataIntegrityViolationException;
import com.firstgroup.gamemanagerapi.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class  GlobalExceptionHandler {

        @ExceptionHandler(ServiceException.class)
        public ResponseEntity<?> error(ServiceException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseUtils.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<?> error(ResourceNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseUtils.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(ResponseUtils.buildErrorResponse(HttpStatus.CONFLICT, "Conflict: Data already exists or violates constraints."));
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> error(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseUtils.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }
