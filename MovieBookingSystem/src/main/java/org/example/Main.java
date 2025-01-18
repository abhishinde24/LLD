package org.example;

import org.example.manager.ShowManager;
import org.example.model.Movie;
import org.example.model.Show;
import org.example.model.Theater;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {

        // instead of creating Manager class for each entities like User, Movie,
        // creating user
        User user1 = new User("Abhishek");
        User user2 = new User("Aadesh");
        User user3 = new User("Mehul");

        // Moive
        Movie movie1 = new Movie("DDLJ");
        Movie movie2 = new Movie("PK");
        Movie movie3 = new Movie("JK");

        // Theather
        Theater theater1 = new Theater("ASHA");
        Theater theater2 = new Theater("BOMBAY");

        // creating shows
        Show show1 = new Show(movie1, theater1, 0L, 2L, 10L);
        Show show2 = new Show(movie1, theater2, 0L, 2L, 10L);
        Show show3 = new Show(movie1, theater1, 3L, 5L, 10L);
        Show show4 = new Show(movie1, theater2, 3L, 5L, 10L);
        Show show5 = new Show(movie2, theater1, 8L, 10L, 10L);
        Show show6 = new Show(movie2, theater2, 11L, 12L, 10L);
        Show show7 = new Show(movie2, theater1, 8L, 10L, 10L);
        Show show8 = new Show(movie2, theater2, 11L, 12L, 10L);

        //
        ShowManager showManager = ShowManager.getInstance();
        showManager.addShow(show1);
        showManager.addShow(show2);
        showManager.addShow(show3);
        showManager.addShow(show4);
        showManager.addShow(show5);
        showManager.addShow(show6);
        showManager.addShow(show7);
        showManager.addShow(show8);

        showManager.ListAllShows();

        showManager.bookTheShow(show1, 2L);
//        showManager.bookTheShow(show1, 2L);
    }
}