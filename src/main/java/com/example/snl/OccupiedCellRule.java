package com.example.snl;

public interface OccupiedCellRule {
    void resolve(Board board, Player mover, int newPosition);
}


