package com.example.snl.rules;

import com.example.snl.WinRule;

public class DefaultWinRule implements WinRule {
    @Override
    public boolean hasWon(int position, int boardSize) {
        return position == boardSize;
    }
}


