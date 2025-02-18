package org.example.asyncHandlers;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.Synchronized;
import org.example.IMessage;
import org.example.ITopic;
import org.example.TopicSubscriber;

public class SubscribWorker implements Runnable{
    private final ITopic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscribWorker(@NonNull final ITopic topic, @NonNull final TopicSubscriber topicSubscriber){
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows
    @Override
    public void run(){
        //  pushing message to subscriber asynchronously
        synchronized (topicSubscriber){
            do{

                int currOffSet = topicSubscriber.getOffSet().get();
                while(currOffSet >= topic.getMessages().size()){
                    topicSubscriber.wait();
                }

                IMessage message = topic.getMessages().get(currOffSet);
                topicSubscriber.getConsumer().consume(message.getContent());

                topicSubscriber.getOffSet().compareAndSet(currOffSet, currOffSet + 1);
            } while(true);
        }
    }

    synchronized public void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
