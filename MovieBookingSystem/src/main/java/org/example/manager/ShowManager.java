package org.example.manager;

import org.example.BookingStatus;
import org.example.model.Seat;
import org.example.model.Show;

import java.util.LinkedList;
import java.util.List;

public class ShowManager {
    private static ShowManager instance;
    private List<Show> shows;

    private ShowManager(){
        this.shows = new LinkedList<>();
    }

    public static ShowManager getInstance(){
        if(instance == null){
            synchronized (ShowManager.class){
               instance = new ShowManager();
            }
        }
        return instance;
    }

    public void addShow(Show show){
        this.shows.add(show);
    }

    public void ListAllShows(){
        for(Show show : shows){
            System.out.printf("Movie Name {%s} Theater {%s} startTime {%d} endTime {%d} \n", show.getMovie().getName(), show.getTheater().getName(), show.getStartTime(), show.getEndTime());
        }
    }

    public Seat bookTheShow(Show show, Long seatNumber){
        Show requiredShow = null;
        for(Show currShow : shows){
            if(currShow.getId().equals(show.getId())) requiredShow = currShow;
        }

        if(requiredShow == null){
            throw new RuntimeException("Show not found");
        }

        // booking set
        return requiredShow.getSeatArrangement().bookSeat(seatNumber);
    }
}
