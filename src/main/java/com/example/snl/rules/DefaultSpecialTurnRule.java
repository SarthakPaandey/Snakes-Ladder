package com.example.snl.rules;

import com.example.snl.SpecialTurnRule;

import java.util.List;

public class DefaultSpecialTurnRule implements SpecialTurnRule {
    @Override
    public Decision decide(List<Integer> rolls) {
        if (rolls.isEmpty()) return new Decision(DecisionType.END_TURN);
        int last = rolls.get(rolls.size() - 1);
        long sixes = rolls.stream().filter(r -> r == 6).count();
        if (sixes >= 3) {
            return new Decision(DecisionType.INVALIDATE_TURN); // revert all moves this turn
        }
        if (last == 6) {
            return new Decision(DecisionType.CONTINUE_TURN);
        }
        return new Decision(DecisionType.END_TURN);
    }
}


