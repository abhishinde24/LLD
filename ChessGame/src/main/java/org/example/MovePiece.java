package org.example;

import lombok.Getter;
import org.example.models.Cell;
import org.example.models.Piece;

@Getter
public class MovePiece {
    private Piece piece;
    private Cell toCell;

    MovePiece(Piece piece, Cell cell){
        this.piece = piece;
        this.toCell = cell;
    }
}
