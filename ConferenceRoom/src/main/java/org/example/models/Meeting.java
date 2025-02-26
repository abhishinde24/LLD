package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Meeting {
    private String id;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private Long startTime;
    @Setter @Getter
    private Long endTime;
    @Setter @Getter
    private Room room;

    public Meeting(String name, Room room, Long startTime, Long endTime){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
