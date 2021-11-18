package com.restaran.restaran.exception;

public class NotFoundUserException extends Exception  {
    public NotFoundUserException(String errorMessage) {
        super(errorMessage);
    }
}