package org.example;

import org.example.exceptions.BadCommandException;
import org.example.manager.CommandExecutor;
import org.example.manager.RoomManager;
import org.example.models.Room;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = CommandExecutor.getInstance();
        RoomManager roomManager = RoomManager.getInstance();

        Room room1 = new Room("1.0","B1","F1");
        Room room2 = new Room("2.0","B2","F2");
        Room room3 = new Room("3.0","B2","F2");
        Room room4 = new Room("4.0","B1","F2");
        Room room5 = new Room("5.0","B1","F2");

        //Adding Rooms
        roomManager.CreateRoom(room1);
        roomManager.CreateRoom(room2);
        roomManager.CreateRoom(room3);
        roomManager.CreateRoom(room4);
        roomManager.CreateRoom(room5);

        //
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String[] cmd = sc.nextLine().split(" ");
            try {
                CommandExecutor.getInstance().execute(cmd);
            } catch (BadCommandException b){
                System.out.println("BadCommand Exception due to ==>" + b.getCause());
            }
        }
    }
}