package org.example.manager;

import lombok.AllArgsConstructor;
import org.example.models.Meeting;
import org.example.models.Room;

import org.example.exceptions.RoomNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RoomManager {
    private Set<Room> rooms;
    static private RoomManager roomManager;

    private RoomManager(){
        this.rooms = new HashSet<>();
    }

    public static synchronized RoomManager getInstance(){
        if(roomManager == null){
            roomManager = new RoomManager();
        }
        return roomManager;
    }

    public static void resetInstance() {
        roomManager = null;
    }

    public boolean CreateRoom(Room room){
        return this.rooms.add(room);
    }

    public List<Room> getRooms(){
        return this.rooms.stream().collect(Collectors.toUnmodifiableList());
    }
}
