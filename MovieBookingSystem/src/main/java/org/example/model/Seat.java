package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.BookingStatus;

import java.util.UUID;

@Getter
@Setter
public class Seat {
    private String id;
    private boolean isLock = false;
    private BookingStatus status;

    public Seat(){
        id = UUID.randomUUID().toString();
        status = BookingStatus.AVAILABLE;
    }
    public boolean Bookable(){
        if(status == BookingStatus.AVAILABLE) return true;
        return false;
    }
    public void bookSeat(){
       if(isLock == false){
           synchronized (Seat.class){
               this.isLock = true;
               this.status = BookingStatus.RESERVED;
               this.isLock = false;
           }
       }
    }
}
