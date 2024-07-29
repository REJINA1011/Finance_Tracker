package com.internship.user_income_allocation.exception;

import com.internship.user_income_allocation.entity.ApiResponse;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TableEmptyException.class)
    public ResponseEntity<ApiResponse> handleTableEmptyException(TableEmptyException ex){

        ApiResponse response= ApiResponse.builder().message(ex.getMessage()).data(null).build();

        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
