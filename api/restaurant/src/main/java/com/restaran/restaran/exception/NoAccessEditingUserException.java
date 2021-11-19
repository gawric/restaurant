package com.restaran.restaran.exception;

public class NoAccessEditingUserException extends Exception{
    public NoAccessEditingUserException(String errorMessage) {
        super(errorMessage);
    }
}
