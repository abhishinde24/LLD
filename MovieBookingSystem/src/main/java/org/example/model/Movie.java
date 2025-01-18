package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Movie {
    private String id;
    private String name;

    public Movie(String name){
        id = UUID.randomUUID().toString();
        this.name = name;
    }
}
