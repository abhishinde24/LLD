package org.example.exceptions;

public class StartTimeGeatherThanEndTimeException extends RuntimeException{
    public StartTimeGeatherThanEndTimeException(String message){
        super(message);
    }
}

