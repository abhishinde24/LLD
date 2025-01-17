package org.example.words;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Color;
import java.util.ArrayList;
import java.util.Collections;

@Getter
@Setter
public class WordState {
    private String currWord;
    private ArrayList<Color> resultantColor;

    public WordState(String givenWord, String requireWord){
        this.currWord = givenWord;
        Integer len = givenWord.length();
        Integer requireLen = requireWord.length();
        if(len != requireLen){
            throw new RuntimeException();
        }

        ArrayList<Color> color = new ArrayList<>(Collections.nCopies(len, Color.RED));
        for(Integer i = 0; i < len; i++){
            if(requireWord.charAt(i) == givenWord.charAt(i)){
                color.set(i, Color.GREEN);
            }
            else if(requireWord.indexOf(givenWord.charAt(i)) != -1){
                color.set(i, Color.YELLOW);
            }
            else{
                color.set(i, Color.RED);
            }
        }
        this.resultantColor = color;
    }
}
