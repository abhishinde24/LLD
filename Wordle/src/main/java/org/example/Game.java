package org.example;

import org.example.enums.State;
import org.example.models.Attempt;
import org.example.enums.Difficulty;
import org.example.words.Word;
import org.example.words.WordState;

public class Game {
    private String target;
    private Integer attempts;
    private Integer wordSize;
    private Attempt attempState;
    private Difficulty difficulty;

    public State state;

    public State getState(){
        return this.state;
    };

    private Game(String correctWord, Integer maxAttempts, Integer wordSize) {
        this.target = correctWord;
        this.wordSize = wordSize;
        this.attempState = new Attempt(maxAttempts);
        this.attempts = 0;
        this.state = State.PLAY;
    }

    public void makeAttempt(String inputWord){
        // check valid word
        if(inputWord.length() != this.wordSize){
            System.out.println("Incorrect word Length");
            return;
        }
        if(!Word.checkValidWord(inputWord)){
            System.out.println("Invalid word entered");
            return;
        }
        // adding word
        try{
            boolean winAttempt = this.attempState.registerAttemps(inputWord, this.target);
            if(winAttempt){
               this.state = State.WIN;
            }
        }
        catch(RuntimeException e){
            System.out.println(e);
            this.state = State.LOSE;
        }
    }

    public void Print(){
        System.out.println("Current state of game");
        for(WordState word : attempState.getAttemps()){
            System.out.print(word.getCurrWord() + " ");
            System.out.println(word.getResultantColor());
        }

        System.out.println("---------------");
    }

    public static class Builder{
        private Integer wordSize;
        private Difficulty difficulty;

        public Builder setWordSize(Integer wordSize){
            this.wordSize = wordSize;
            return this;
        }

        public Builder setDifficulty(Difficulty difficulty){
            this.difficulty = difficulty;
            return this;
        }

        public Game Build(){
            Integer attempts = 6;
            //Validation
            if(wordSize == null || difficulty == null){
                throw new RuntimeException("Invalid builder object");
            }
            if(difficulty == Difficulty.EASY) attempts = 6;
            else if(difficulty == Difficulty.MEDIUM) attempts = 5;
            else if(difficulty == Difficulty.HARD) attempts = 4;
            String targetWord = Word.getRandowWord();
            return new Game(targetWord,attempts,wordSize);
        }
    }

}
