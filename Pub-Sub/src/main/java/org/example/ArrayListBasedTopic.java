package org.example;

import jdk.jshell.ImportSnippet;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArrayListBasedTopic implements ITopic {
    private String id;
    private List<IMessage> messages;
    private List<TopicSubscriber> consumers;
    private Long offSet;

    ArrayListBasedTopic(){
        this.id = UUID.randomUUID().toString();
        this.messages = new ArrayList<>();
        this.consumers = new ArrayList<>();
        this.offSet = 0L;
    }

    public String getId(){
        return this.id;
    }

    public List<IMessage> getMessages(){
        return this.messages;
    }

    public List<TopicSubscriber> getConsumers(){
        return this.consumers;
    }

    public void addMessage(@NonNull final IMessage message) {
        messages.add(message);
    }

    public void addConsumer(TopicSubscriber consumer) {
        this.consumers.add(consumer);
    }
}
