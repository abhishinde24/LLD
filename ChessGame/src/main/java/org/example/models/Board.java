package org.example.models;

import org.example.types.Color;

public class Board {
    private int row; // y
    private int col; // x
    private Cell[][] cells;

    public Board(int row, int col){
        this.row = row;
        this.col = col;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    /*
     coordinate visualization
     x , y
     left x = x - 1;
     right x = x + 1;
     up y = y + 1
     down y = y - 1
    */

    public Cell getLeft(Cell cell){
        return getCell(cell.getX() - 1, cell.getY());
    }

    public Cell getRight(Cell cell){
        return getCell(cell.getX() + 1, cell.getY());
    }

    public Cell getTop(Cell cell){
        return getCell(cell.getX(), cell.getY() - 1);
    }

    public Cell getDown(Cell cell){
        return getCell(cell.getX(), cell.getY() + 1);
    }

    public Cell getTopRight(Cell cell){
        return getCell(cell.getX() + 1, cell.getY() - 1);
    }

    public Cell getTopLeft(Cell cell){
        return getCell(cell.getX() - 1, cell.getY() - 1);
    }

    public Cell getBottomRight(Cell cell){
        return getCell( cell.getX() + 1, cell.getY() + 1);
    }

    public Cell getBottomLeft(Cell cell){
        return getCell(cell.getX() - 1, cell.getY() + 1);
    }

    public Cell getCell(int x, int y){
        if(x < 0 || x >= this.col || y < 0 || y >= this.row)  return null;
        return cells[y][x];
    }

//    public boolean makeMove(Piece target, Cell destinationCell){
//
//    }

}
