package org.example;

import java.util.UUID;

public class LazzyConsumer implements IConsumer{
    private String id;

    public LazzyConsumer(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return this.id;
    }

    public void consume(String message){
        System.out.println("Lazzy consumer received message: " + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lazzy consumer finished processing message: " + message);
    }
}
