package org.example;

public class LazzyConsumer implements IConsumer{
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
