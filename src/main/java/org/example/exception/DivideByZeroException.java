package org.example.exception;

public class DivideByZeroException extends Throwable {
    public DivideByZeroException(String message){
        super(message);
    }
}
