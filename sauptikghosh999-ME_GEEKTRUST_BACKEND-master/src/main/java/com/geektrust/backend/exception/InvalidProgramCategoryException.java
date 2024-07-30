package com.geektrust.backend.exception;

//Exception for invalid programs
public class InvalidProgramCategoryException extends RuntimeException {

    public InvalidProgramCategoryException() {
        super();
    }

    public InvalidProgramCategoryException(String message) {
        super(message);
    }
}