package org.example.models;

import org.example.MovePiece;
import org.example.types.Color;
import org.example.types.PieceType;

import java.util.ArrayList;

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

    public void addPiece(Player player, int pawnRow, int pieceRow, Color color){

        // setting up pawn
        for(int colIdx = 0; colIdx < this.col; colIdx++){
           this.getCell(colIdx, pawnRow).setPiece( new Piece( PieceType.PAWN, new ArrayList<>(), color));
           player.addPiece(this.getCell(colIdx, pawnRow).getPiece());
        }

        // setting up pieces
        this.getCell(0, pieceRow).setPiece( new Piece(PieceType.BISHOP, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());

        this.getCell(1, pieceRow).setPiece( new Piece(PieceType.KNIGHT, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());

        this.getCell(2, pieceRow).setPiece( new Piece(PieceType.ROOK, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());

        this.getCell(3, pieceRow).setPiece( new Piece(PieceType.QUEEN, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());

        this.getCell(4, pieceRow).setPiece( new Piece(PieceType.KING, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());

        this.getCell(5, pieceRow).setPiece( new Piece(PieceType.ROOK, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());

        this.getCell(6, pieceRow).setPiece( new Piece(PieceType.KNIGHT, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());

        this.getCell(7, pieceRow).setPiece( new Piece(PieceType.BISHOP, new ArrayList<>(), color));
        player.addPiece(this.getCell(0, pieceRow).getPiece());
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
