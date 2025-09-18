package com.example.snl;

import java.util.List;

public interface SpecialTurnRule {
    enum DecisionType { CONTINUE_TURN, END_TURN, INVALIDATE_TURN }

    class Decision {
        public final DecisionType type;

        public Decision(DecisionType type) {
            this.type = type;
        }
    }

    Decision decide(List<Integer> rolls);
}


