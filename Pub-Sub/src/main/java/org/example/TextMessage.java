package org.example;

import java.util.UUID;

public class TextMessage implements IMessage{
    private String id;
    private String content;

    TextMessage(String content){
        this.id = UUID.randomUUID().toString();
        this.content = content;
    }

    public String getId(){
        return this.id;
    }

    public String getContent(){
        return this.content;
    }
}
