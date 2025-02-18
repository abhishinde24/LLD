package org.example;

import java.util.UUID;

public class FastConsumer implements IConsumer{

    private String id;

    public FastConsumer(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return this.id;
    }

    public void consume(String message){

        System.out.println("Fast consumer received message: " + message);
        System.out.println("Fast consumer finished processing message: " + message);
    }
}
