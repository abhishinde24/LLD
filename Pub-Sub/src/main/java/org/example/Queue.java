package org.example;

import java.util.HashMap;
import java.util.Map;

public class Queue {
    private Map<String, TopicHandler> topicProcessors;

    Queue(){
        this.topicProcessors = new HashMap<>();
    }

    void addTopic(String topicId, ITopic topic){
        TopicHandler topicHandler = new TopicHandler(topic);
        this.topicProcessors.put(topicId, topicHandler);
    }

    public void publish(ITopic topic, IMessage message){
        topic.addMessage(message);
        System.out.println("Message published to topic: " + topic.getId());
        new Thread(() -> topicProcessors.get(topic.getId()).publish()).start();
    }
}
