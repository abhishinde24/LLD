package org.example;

import org.example.enums.Difficulty;
import org.example.enums.State;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Game.Builder wordleBuilder = new Game.Builder().setDifficulty(Difficulty.EASY).setWordSize(5);

       Game wordle = wordleBuilder.Build();

        Scanner scanner = new Scanner(System.in);
       while(wordle.getState() == State.PLAY){
           wordle.Print();
           String entriedWord = scanner.next();
           wordle.makeAttempt(entriedWord);
       }
    }
}