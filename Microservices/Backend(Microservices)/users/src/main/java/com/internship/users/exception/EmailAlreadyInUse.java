package com.internship.users.exception;

public class EmailAlreadyInUse extends RuntimeException{
    public EmailAlreadyInUse(){}
    public EmailAlreadyInUse(String message){
        super(message);
    }
}
