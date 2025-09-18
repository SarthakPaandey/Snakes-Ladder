package com.example.snl.rules;

import com.example.snl.Board;
import com.example.snl.MoveRule;
import com.example.snl.Player;

public class DefaultMoveRule implements MoveRule {
    @Override
    public int computeTarget(Board board, Player player, int currentPosition, int roll) {
        int tentative = currentPosition + roll;
        if (tentative > board.getSize()) {
            return currentPosition; // overshoot cancels move
        }
        int afterEntity = board.applyEntities(tentative);
        return afterEntity;
    }
}


