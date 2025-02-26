package org.example.manager;


import org.example.bookingStrategy.IBookingStrategy;
import org.example.bookingStrategy.TimeBasedBookingStrategy;
import org.example.exceptions.StartTimeGeatherThanEndTimeException;
import org.example.models.Meeting;
import org.example.models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingManager {
    private static BookingManager bookingManager;
    private HashMap<String, List<Meeting>> bookings;
    private IBookingStrategy bookingStrategy;

    private BookingManager(IBookingStrategy bookingStrategy){
        this.bookings = new HashMap<>();
        this.bookingStrategy = bookingStrategy;
    }

    public static synchronized BookingManager getInstance(){
        if(bookingManager == null){
            bookingManager = new BookingManager(new TimeBasedBookingStrategy());
        }
        return bookingManager;
    }

    public static void resetInstance() {
        bookingManager   = null;
    }

    public Meeting bookRoom(Long startTime, Long endTime){

        Meeting meeting = null;
        if(startTime > endTime){
            throw new StartTimeGeatherThanEndTimeException("StartTime geather then EndTime");
        }
        List<Room> rooms = RoomManager.getInstance().getRooms();
        for(Room room : rooms){
            List<Meeting> meetings = this.bookings.getOrDefault(room.getId(),new ArrayList<>());
            meeting = bookingStrategy.bookRoom(room, meetings, startTime, endTime);
            if(meeting != null){
                break;
            }
        }
        if(meeting == null){
            throw new RuntimeException("No Meeting room available in given time span");
        }
        if(!this.bookings.containsKey(meeting.getRoom().getId())){
            this.bookings.put(meeting.getRoom().getId(),new ArrayList<>());
        }
        this.bookings.get(meeting.getRoom().getId()).add(meeting);
        return meeting;
    }

    public List<Meeting> getMeetsForRoom(Room room){
       return this.bookings.getOrDefault(room.getId(),new ArrayList<>());
    }
}
