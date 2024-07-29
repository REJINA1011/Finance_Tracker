package com.internship.user_income.exception;

public class EmailAlreadyInUse extends RuntimeException{
    public EmailAlreadyInUse(){}
    public EmailAlreadyInUse(String message){
        super(message);
    }
}
