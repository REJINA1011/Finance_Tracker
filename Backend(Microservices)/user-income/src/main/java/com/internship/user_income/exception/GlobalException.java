package com.internship.user_income.exception;

import com.internship.user_income.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistException(UserNotFoundException userNotFoundException){
        ErrorResponse response= ErrorResponse.builder().message(userNotFoundException.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmailAlreadyInUse.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyInUser(EmailAlreadyInUse emailAlreadyInUse){
        ErrorResponse response= ErrorResponse.builder().message(emailAlreadyInUse.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
