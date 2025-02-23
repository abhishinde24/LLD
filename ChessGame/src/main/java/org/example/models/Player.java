package org.example.models;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private List<Piece> pieces;

    public Player(){
        pieces = new LinkedList<>();
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }
}
