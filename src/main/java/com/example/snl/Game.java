package com.example.snl;

import com.example.snl.SpecialTurnRule.Decision;
import com.example.snl.SpecialTurnRule.DecisionType;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private final RuleSet rules;

    public Game(Board board, List<Player> players, Dice dice, RuleSet rules) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.rules = rules;
        for (Player p : players) {
            board.registerPlayer(p);
            board.setPosition(p, 0);
        }
    }

    public Player play() {
        Deque<Player> turnOrder = new ArrayDeque<>(players);
        while (true) {
            Player current = turnOrder.removeFirst();
            Player winner = takeTurn(current);
            if (winner != null) {
                return winner;
            }
            turnOrder.addLast(current);
        }
    }

    private Player takeTurn(Player player) {
        int startOfTurnPosition = board.getPosition(player);
        List<Integer> rollsThisTurn = new ArrayList<>();
        boolean continueTurn = true;
        while (continueTurn) {
            int roll = dice.roll();
            rollsThisTurn.add(roll);

            int currentPosition = board.getPosition(player);
            boolean canStart = rules.getStartingRule().canEnterBoard(currentPosition, roll);
            int afterMove = currentPosition;
            if (canStart) {
                afterMove = rules.getMoveRule().computeTarget(board, player, currentPosition, roll);
                board.setPosition(player, afterMove);
                rules.getOccupiedCellRule().resolve(board, player, afterMove);
            }

            if (rules.getWinRule().hasWon(board.getPosition(player), board.getSize())) {
                return player;
            }

            Decision decision = rules.getSpecialTurnRule().decide(rollsThisTurn);
            if (decision.type == DecisionType.INVALIDATE_TURN) {
                board.setPosition(player, startOfTurnPosition);
                continueTurn = false;
            } else if (decision.type == DecisionType.CONTINUE_TURN) {
                continueTurn = true;
            } else {
                continueTurn = false;
            }
        }
        return null;
    }
}


