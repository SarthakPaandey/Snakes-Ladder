package com.example.snl;

import java.util.Random;

public class Dice {
    private static volatile Dice instance;
    private final int sides;
    private final Random random;

    private Dice(int sides) {
        if (sides <= 1) {
            throw new IllegalArgumentException("Dice must have at least 2 sides");
        }
        this.sides = sides;
        this.random = new Random();
    }

    public static Dice getInstance() {
        if (instance == null) {
            synchronized (Dice.class) {
                if (instance == null) {
                    instance = new Dice(6);
                }
            }
        }
        return instance;
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }

    public int getSides() {
        return sides;
    }
}


