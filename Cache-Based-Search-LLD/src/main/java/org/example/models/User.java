package org.example.models;


import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    private String id;
    @Setter
    private String name;
    @Setter
    private String genre;

    public User(String id,String name, String genre){
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
}
