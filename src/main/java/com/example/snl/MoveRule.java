package com.example.snl;

public interface MoveRule {
    int computeTarget(Board board, Player player, int currentPosition, int roll);
}


