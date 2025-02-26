package org.example.command;

import org.example.manager.BookingManager;
import org.example.models.Meeting;

public class BookMeetingCommand implements CommandI{

    /*
    * Book startTime endTime
    * */
    @Override
    public void execute(String cmd[]){
        if(cmd.length != 3){
            throw new RuntimeException("Invalid number of Argument");
        }
        Long startTime = Long.parseLong(cmd[1]) ;
        Long endTime = Long.parseLong(cmd[2]);
        Meeting meeting = BookingManager.getInstance().bookRoom(startTime, endTime);
        if(meeting == null){
            throw new RuntimeException("Exception while booking meeting");
        }
        System.out.println("Meeting Booked succfully");
    }
}
