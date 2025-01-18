package org.example.model;

import java.util.UUID;

public class User {
    private String id;
    private String Username;

    public User(String name){
        id = UUID.randomUUID().toString();
        this.Username = name;
    }
}
