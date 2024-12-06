package org.example.commands;

import org.example.Manager.MovieManager;
import org.example.Manager.UserManager;
import org.example.models.Movie;
import org.example.models.User;

import java.security.interfaces.DSAPublicKey;

public class AddMovieCommand implements ICommand{
    public void executeCommand(String cmd[]){
        if(cmd.length != 6){
            throw new RuntimeException();
        }
        String movieId = cmd[1];
        String name = cmd[2];
        String genre = cmd[3];
        Long year = Long.parseLong(cmd[4]);
        Double rating = Double.parseDouble(cmd[5]);


        Movie movie = new Movie(movieId, name, genre, year, rating);
        MovieManager.getInstance().createMovie(movie);
    }
}
