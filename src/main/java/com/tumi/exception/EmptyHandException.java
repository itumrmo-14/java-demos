package com.tumi.exception;

public class EmptyHandException extends Exception{
    public EmptyHandException() {
        super();
    }

    public EmptyHandException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
