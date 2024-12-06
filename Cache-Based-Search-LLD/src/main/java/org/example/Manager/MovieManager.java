package org.example.Manager;

import org.example.models.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieManager {
    private Map<String, Movie> movies;
    private static MovieManager movieManager;

    private MovieManager(){
        this.movies = new HashMap<>();
    }

    public static synchronized MovieManager getInstance(){
        if(movieManager == null){
            movieManager = new MovieManager();
        }
        return movieManager;
    }

    public void createMovie(Movie movie){
        if(movies.containsKey(movie.getId())){
            throw new RuntimeException("Duplicate Id");
        }
        movies.put(movie.getId(),movie);
    }

    public List<Movie> getMovies(){
        return movies.values().stream().collect(Collectors.toList());
    }
}
