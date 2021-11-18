package com.restaran.restaran.exception;

public class IncorrectUserNameException extends Exception  {
    public IncorrectUserNameException(String errorMessage) {
        super(errorMessage);
    }
}
