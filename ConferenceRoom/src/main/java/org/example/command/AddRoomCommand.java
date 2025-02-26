package org.example.command;

import org.example.manager.RoomManager;
import org.example.models.Room;

public class AddRoomCommand implements CommandI {

    /*
    * command format ADD ROOM roomName Buidling Floor
    * */
    @Override
    public void execute(String cmd[]){
        if(cmd.length !=  3){
            throw new RuntimeException("Invalid number of argument for ADD command");
        }
        Room room = new Room( cmd[2], cmd[3], cmd[4]);
        RoomManager.getInstance().CreateRoom(room);
        System.out.println("Room added successfully");
    }
}
