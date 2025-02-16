package org.example;

import java.util.HashMap;
import java.util.Map;

public class Queue {
    private Map<String, ITopic> topics;

    Queue(){
        this.topics = new HashMap<>();
    }

    void addTopic(String topicId, ITopic topic){
        this.topics.put(topicId, topic);
    }

    String publish(String topicId, IMessage message){
        ITopic topic = this.topics.get(topicId);
        if(topic == null){
            return "Topic not found";
        }
        topic.publish(message);
        return "Message published";
    }
}
