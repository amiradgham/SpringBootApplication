package com.example.miniproject.exception;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String messsage){
        super(messsage);
    }
}

