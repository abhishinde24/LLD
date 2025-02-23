package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.exceptions.InvalidMoveException;
import org.example.providers.PossibleMoveProvider;
import org.example.types.PieceType;
import org.example.types.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
public class Piece {
    private boolean isKilled;
    private int numMoves = 0;
    private Color color;
    private List<PossibleMoveProvider> moveProviders;
    private PieceType pieceType;

    @Setter
    private Cell currentCell;

    void Piece(PieceType pieceType, Color color){
       this.isKilled = false;
       this.pieceType = pieceType;
       this.color = color;
    }

    public void kill(){
        this.isKilled = true;
    }

    public void makeMove(Player player, Cell toCell, Board board){
        if(this.isKilled) return;

        List<Cell> nextPossibleCells = nextPossibleCells();

        if(!nextPossibleCells.contains(toCell)){
            throw new InvalidMoveException("Invalid move");
        }

        // now if move is valid, lets check of destination cell is having any kill
        if(toCell.getPiece()!=null) toCell.getPiece().kill();
        this.currentCell.setPiece(null);
        this.currentCell = toCell;
        this.currentCell.setPiece(this);
        this.numMoves++;
    }

    public List<Cell> nextPossibleCells(){
        List<Cell> result = new ArrayList<>();
        for(PossibleMoveProvider moveProvider : this.moveProviders){
            List<Cell> nextMoves = moveProvider.getPossibleCells();
            if(nextMoves != null){
                result.addAll(nextMoves);
            }
        }
        return result;
    }

}
