package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cell {
    private int X;
    private int Y;

    public Cell(int x, int y){
        this.X = x;
        this.Y = y;
    }

    @Setter
    private Piece piece;

}
