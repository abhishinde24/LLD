package org.example;

public interface ITopic {
    String getId();
    void publish(IMessage message);
    void addConsumer(IConsumer consumer);
}
