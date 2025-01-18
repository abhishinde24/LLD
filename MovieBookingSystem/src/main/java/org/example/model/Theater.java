package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Theater {
    private String id;
    private String name;

    public Theater(String name){
        id = UUID.randomUUID().toString();
        this.name = name;
    }
}
