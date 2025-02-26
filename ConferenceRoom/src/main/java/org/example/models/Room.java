package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private String id;
    private String roomString;
    private String building;
    private String floor;

    public Room(String roomString, String building, String floor){
        this.id = UUID.randomUUID().toString();
        this.roomString = roomString;
        this.building = building;
        this.floor = floor;
    }
}
