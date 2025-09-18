package com.example.snl;

public class RuleSet {
    private final StartingRule startingRule;
    private final MoveRule moveRule;
    private final OccupiedCellRule occupiedCellRule;
    private final SpecialTurnRule specialTurnRule;
    private final WinRule winRule;

    public RuleSet(
            StartingRule startingRule,
            MoveRule moveRule,
            OccupiedCellRule occupiedCellRule,
            SpecialTurnRule specialTurnRule,
            WinRule winRule
    ) {
        this.startingRule = startingRule;
        this.moveRule = moveRule;
        this.occupiedCellRule = occupiedCellRule;
        this.specialTurnRule = specialTurnRule;
        this.winRule = winRule;
    }

    public StartingRule getStartingRule() {
        return startingRule;
    }

    public MoveRule getMoveRule() {
        return moveRule;
    }

    public OccupiedCellRule getOccupiedCellRule() {
        return occupiedCellRule;
    }

    public SpecialTurnRule getSpecialTurnRule() {
        return specialTurnRule;
    }

    public WinRule getWinRule() {
        return winRule;
    }
}


