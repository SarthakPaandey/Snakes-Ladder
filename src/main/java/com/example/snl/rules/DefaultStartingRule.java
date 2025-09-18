package com.example.snl.rules;

import com.example.snl.StartingRule;

public class DefaultStartingRule implements StartingRule {
    @Override
    public boolean canEnterBoard(int currentPosition, int roll) {
        if (currentPosition > 0) return true;
        return roll == 6;
    }
}


