package com.internship.user_accounts.exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(){}
    public DataNotFoundException(String message){
        super(message);
    }
}
