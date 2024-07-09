package com.internship.user_accounts.exception;

import com.internship.user_accounts.entity.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ApiResponse> handleDataNotFoundException(DataNotFoundException ex){

        ApiResponse response=ApiResponse.builder().message(ex.getMessage()).data(null).build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
