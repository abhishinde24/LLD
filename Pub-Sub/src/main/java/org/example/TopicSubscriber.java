package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class TopicSubscriber {
    private IConsumer consumer;
    private AtomicInteger offSet;

    public TopicSubscriber(IConsumer consumer){
        this.consumer = consumer;
        this.offSet = new AtomicInteger(0);
    }
}
