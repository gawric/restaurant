package com.restaran.restaran.variable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public  class ErrorMessage {

    public static ResponseEntity<Object> getResponceError(String errorName)
    {
        return new ResponseEntity(HttpStatus.FORBIDDEN)
                .status(HttpStatus.FORBIDDEN)
                .body("Error Message: " + errorName);
    }


}
