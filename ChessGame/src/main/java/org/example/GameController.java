package org.example;

import lombok.AllArgsConstructor;
import org.example.models.Board;
import org.example.models.Player;

import java.util.List;

@AllArgsConstructor
public class GameController {
    private Board board;
    private List<Player> players;


    void Play(){
       int currPlayer = 0;
       while(true){

           Player player = players.get(currPlayer);
           MovePiece playerMove = player.makeMove();
           player.movePiece(playerMove, this.board);
           currPlayer = (currPlayer + 1)%players.size();
       }
    }

}
