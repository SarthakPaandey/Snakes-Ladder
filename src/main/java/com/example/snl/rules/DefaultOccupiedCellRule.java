package com.example.snl.rules;

import com.example.snl.Board;
import com.example.snl.OccupiedCellRule;
import com.example.snl.Player;

import java.util.List;

public class DefaultOccupiedCellRule implements OccupiedCellRule {
    @Override
    public void resolve(Board board, Player mover, int newPosition) {
        List<Player> occupants = board.getPlayersAt(newPosition);
        for (Player occupant : occupants) {
            if (!occupant.getId().equals(mover.getId())) {
                board.setPosition(occupant, 0); // send occupant to start
            }
        }
    }
}


