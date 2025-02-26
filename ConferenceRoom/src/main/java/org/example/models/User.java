package org.example.models;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public class User {
    private String id;
    @Getter @Setter private String name;

    public User(final String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
