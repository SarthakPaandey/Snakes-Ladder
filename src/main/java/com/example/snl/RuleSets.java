package com.example.snl;

import com.example.snl.rules.DefaultMoveRule;
import com.example.snl.rules.DefaultOccupiedCellRule;
import com.example.snl.rules.DefaultSpecialTurnRule;
import com.example.snl.rules.DefaultStartingRule;
import com.example.snl.rules.DefaultWinRule;

public class RuleSets {
    public static RuleSet defaultRules() {
        return new RuleSet(
                new DefaultStartingRule(),
                new DefaultMoveRule(),
                new DefaultOccupiedCellRule(),
                new DefaultSpecialTurnRule(),
                new DefaultWinRule()
        );
    }
}


