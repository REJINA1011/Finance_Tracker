package com.internship.user_income_allocation.exception;

public class TableEmptyException extends RuntimeException{

    public TableEmptyException(){}
    public TableEmptyException(String message){
        super(message);
    }
}
