package org.example.bookingStrategy;

import org.example.exceptions.MaxBookingWindowExceed;
import org.example.exceptions.StartTimeGeatherThanEndTimeException;
import org.example.models.Meeting;
import org.example.models.Room;

import java.util.List;

public class TimeBasedBookingStrategy implements IBookingStrategy{
    private Long maxBookingWindow = 200L;

    @Override
    public Meeting bookRoom(Room room, List<Meeting> meetings, Long startTime, Long endTime) {

        if(endTime - startTime > maxBookingWindow){
            throw new MaxBookingWindowExceed("Max booking window exceed");
        }

        boolean canBook = true;

        for(Meeting meeting : meetings){
            if(!(startTime >= meeting.getEndTime() || endTime <= meeting.getStartTime())){
                canBook = false;
            }
        }

        return canBook ? new Meeting("Meeting", room, startTime, endTime) : null;
    }
}
