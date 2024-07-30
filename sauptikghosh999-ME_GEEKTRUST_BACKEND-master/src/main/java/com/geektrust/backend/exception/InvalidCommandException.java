package com.geektrust.backend.exception;

//Exception for invalid commands
public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException()
    {
        super();
    }
    public InvalidCommandException(String msg)
    {
        super(msg);
    }
}