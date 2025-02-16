package org.example;

public class FastConsumer implements IConsumer{
    public void consume(String message){
        System.out.println("Fast consumer received message: " + message);
        System.out.println("Fast consumer finished processing message: " + message);
    }
}
