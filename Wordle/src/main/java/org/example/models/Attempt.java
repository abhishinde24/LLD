package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.words.WordState;

import java.util.LinkedList;

@Getter
@Setter
public class Attempt {
    private LinkedList<WordState> attemps;
    private Integer totalAttemps;

    public Attempt(Integer numberOfAttempts){
        this.attemps = new LinkedList<>();
        totalAttemps = numberOfAttempts;
    }

    public boolean registerAttemps(String word, String target){
        if(attemps.size() >= totalAttemps){
            throw new RuntimeException("No number of attempts remaning");
        }
        WordState wordState = new WordState(word, target);
        attemps.add(wordState);
        if(word == target){
            return true;
        }
        return false;
    }
}
