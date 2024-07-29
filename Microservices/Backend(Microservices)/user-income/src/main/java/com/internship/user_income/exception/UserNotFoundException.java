package com.internship.user_income.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){}
    public UserNotFoundException(String message){
        super(message);
    }
}
