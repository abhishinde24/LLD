package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SeatArrangement {
    private List<Seat> seats;

    public SeatArrangement(Long numberOfSeats){
        this.seats = new ArrayList<>();
        for(int count = 0; count < numberOfSeats; count++){
            seats.add(new Seat());
        }
    }

    public Seat bookSeat(Long seatNumber){
        if(seats.size() <= seatNumber){
            throw new RuntimeException("Invalid seat number");
        }
        Seat bookedSeat = null;
        if(seats.get(seatNumber.intValue()).Bookable()){
            seats.get(seatNumber.intValue()).bookSeat();
            return seats.get(seatNumber.intValue());
        }

        throw new RuntimeException("Seat not bookable");
    }
}
