package org.example.models;

import org.example.MovePiece;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {
    private List<Piece> pieces;
    private String name;

    public Player(String name){
        this.name = name;
        pieces = new LinkedList<>();
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public void movePiece(MovePiece movePiece, Board board){
        movePiece.getPiece().makeMove(this, movePiece.getToCell(), board);
    }

    abstract public MovePiece makeMove();
}
