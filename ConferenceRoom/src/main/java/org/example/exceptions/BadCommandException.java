package org.example.exceptions;

public class BadCommandException extends RuntimeException{
    public BadCommandException(String message){
        super(message);
    }
}
