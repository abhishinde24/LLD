package org.example.bookingStrategy;

import org.example.models.Room;
import org.example.models.Meeting;

import java.util.List;

public interface IBookingStrategy {
    Meeting bookRoom(Room room, List<Meeting> meeting, Long StartTime, Long EndTime);
}
