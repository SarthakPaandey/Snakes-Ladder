package com.example.snl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int size = 100;
        List<int[]> snakes = Arrays.asList(
                new int[]{99, 10},
                new int[]{95, 42},
                new int[]{80, 3}
        );
        List<int[]> ladders = Arrays.asList(
                new int[]{2, 38},
                new int[]{7, 14},
                new int[]{8, 31},
                new int[]{28, 84}
        );

        Board board = BoardFactory.standardBoard(size, snakes, ladders);
        Player p1 = new HumanPlayer("P1", "Alice");
        Player p2 = new BotPlayer("P2", "Bot");
        RuleSet rules = RuleSets.defaultRules();

        Game game = new Game(board, Arrays.asList(p1, p2), Dice.getInstance(), rules);
        Player winner = game.play();
        System.out.println("Winner: " + winner.getName());
    }
}


