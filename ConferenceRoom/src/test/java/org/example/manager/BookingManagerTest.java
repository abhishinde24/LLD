package org.example.manager;

import org.example.bookingStrategy.IBookingStrategy;
import org.example.bookingStrategy.TimeBasedBookingStrategy;
import org.example.models.Meeting;
import org.example.models.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingManagerTest {
    BookingManager bookingManager;
    RoomManager roomManager;

    @BeforeEach
    void setup(){
        Room room1 = new Room("1.1","B1","F1");
        Room room2 = new Room("1.2","B1","F1");
        Room room3 = new Room("1.3","B1","F1");
        Room room4 = new Room("1.4","B1","F1");

        roomManager = RoomManager.getInstance();
        roomManager.CreateRoom(room1);
        roomManager.CreateRoom(room2);
        roomManager.CreateRoom(room3);
        roomManager.CreateRoom(room4);

        bookingManager = BookingManager.getInstance();
    }
    @AfterEach
    void cleanUp(){
        RoomManager.resetInstance();
        BookingManager.resetInstance();
    }

    @Test
    void test_bookRowWithInvalidTime(){
        assertThrows(RuntimeException.class, () -> bookingManager.bookRoom(20L,5L));
    }

    @Test
    void test_bookRoomIsAvailable(){
        Meeting meet1 = bookingManager.bookRoom(20L,30L);
        assertNotNull(meet1);

        Meeting meet2 = bookingManager.bookRoom(20L,30L);
        assertNotNull(meet2);

        Meeting meet3 = bookingManager.bookRoom(20L,30L);
        assertNotNull(meet3);
    }

    @Test
    void test_bookRoomNotAvailable(){
        Meeting meet1 = bookingManager.bookRoom(20L,30L);
        Meeting meet2 = bookingManager.bookRoom(20L,30L);
        Meeting meet3 = bookingManager.bookRoom(20L,30L);
        Meeting meet4 = bookingManager.bookRoom(20L,30L);

        System.out.println("Final Statement ----");
        assertThrows(RuntimeException.class, () -> bookingManager.bookRoom(20L,30L));
    }
}
