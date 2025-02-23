package org.example.providers;

import org.example.models.Cell;

import java.util.List;

public interface PossibleMoveProvider {
    public List<Cell> getPossibleCells();
}
