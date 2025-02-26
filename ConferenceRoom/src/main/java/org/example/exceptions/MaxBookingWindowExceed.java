package org.example.exceptions;

public class MaxBookingWindowExceed extends RuntimeException{
    public MaxBookingWindowExceed(String message){
        super(message);
    }
}
