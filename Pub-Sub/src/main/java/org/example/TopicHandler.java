package org.example;

import lombok.NonNull;
import org.example.asyncHandlers.SubscribWorker;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private final ITopic topic;
    private final Map<String, SubscribWorker> subscribWorkerMap;

    public TopicHandler(@NonNull final ITopic topic){
        this.topic = topic;
        this.subscribWorkerMap = new HashMap<>();
    }

    public void publish(){
        for (TopicSubscriber topicSubscriber : topic.getConsumers()){
            startSubscribWorker(topicSubscriber);
        }
    }

    public void startSubscribWorker(@NonNull final TopicSubscriber topicSubscriber){
        final String subscriberId = topicSubscriber.getConsumer().getId();
        if(!subscribWorkerMap.containsKey(subscriberId)){
            final SubscribWorker subscribWorker = new SubscribWorker(topic, topicSubscriber);
            subscribWorkerMap.put(subscriberId, subscribWorker);
            new Thread(subscribWorker).start();
        }
        final SubscribWorker subscribWorker = subscribWorkerMap.get(subscriberId);
        subscribWorker.wakeUpIfNeeded();
    }
}
