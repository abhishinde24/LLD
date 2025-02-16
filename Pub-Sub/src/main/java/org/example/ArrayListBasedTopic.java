package org.example;

import jdk.jshell.ImportSnippet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArrayListBasedTopic implements ITopic {
    private String id;
    private List<IMessage> messages;
    private List<IConsumer> consumers;
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

    @Override
    public void publish(IMessage message) {
        messages.add(message);
        pushMessageToConsumers(this.offSet);
    }

    @Override
    public void addConsumer(IConsumer consumer) {
        this.consumers.add(consumer);
    }

    private void pushMessageToConsumers(Long offSet){
        while(offSet < this.messages.size()){
            String message = this.messages.get(offSet.intValue()).getContent();
            for(IConsumer consumer : this.consumers){
                consumer.consume(message);
            }
            offSet = offSet + 1;
        }
    }
}
