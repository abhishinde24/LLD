package org.example;

import java.util.List;

public interface ITopic {
    String getId();
    List<IMessage> getMessages();
    List<TopicSubscriber> getConsumers();
    void addMessage(IMessage message);
    void addConsumer(TopicSubscriber consumer);
}
