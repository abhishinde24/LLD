package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
public class Movie {
    private String id;
    @Setter
    private String title;
    @Setter
    private String genre;
    @Setter
    private Long year;
    @Setter
    private Double rating;

    public Movie(String id, String title, String genre, Long year, Double rating){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public boolean isMatch(Movie movie){
        if(movie.getTitle().equals(this.title) || movie.getGenre().equals(this.genre)
                || movie.getYear().equals(this.year) || movie.getRating().equals(this.rating)){
            return true;
        }
        return false;
    }
}
