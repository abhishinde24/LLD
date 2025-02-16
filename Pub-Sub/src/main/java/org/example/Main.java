package org.example;

public class Main {
    public static void main(String[] args) {
        IConsumer conS1 = new LazzyConsumer();
        IConsumer conF1 = new FastConsumer();
        IConsumer conS2 = new LazzyConsumer();
        IConsumer conF2 = new FastConsumer();

        ITopic topic1 = new ArrayListBasedTopic();
        ITopic topic2 = new ArrayListBasedTopic();

        topic1.addConsumer(conS1);
        topic1.addConsumer(conF1);

        topic2.addConsumer(conS2);
        topic2.addConsumer(conF2);

        Queue queue = new Queue();
        queue.addTopic(topic1.getId(), topic1);
        queue.addTopic(topic2.getId(), topic2);

        queue.publish(topic1.getId(), new TextMessage("Hello world! For topic 1"));
        queue.publish(topic2.getId(), new TextMessage("Hello world! For topic 2"));

        System.out.println("Hello world!");
    }
}