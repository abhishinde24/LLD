package org.example.exceptions;

public class StorageFullException extends Exception{
    public StorageFullException(String message){
        super(message);
    }
}
