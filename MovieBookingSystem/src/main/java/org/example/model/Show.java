package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Show {
    private String id;
    private Movie movie;
    private Theater theater;
    private Long startTime;
    private Long endTime;
    private SeatArrangement seatArrangement;

    public Show(Movie movie, Theater theater, Long startTime, Long endTime, Long numberOfSeats){
        this.id = UUID.randomUUID().toString();
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.endTime = endTime;

        this.seatArrangement = new SeatArrangement(numberOfSeats);
    }

    public void bookShow(Long seatNumber){
        if(seatArrangement.bookSeat(seatNumber) == null){
           throw new RuntimeException("Seat is not bookable");
        }
    }
}
