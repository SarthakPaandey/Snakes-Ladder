package com.example.snl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardFactory {
    public static Board standardBoard(int size, List<int[]> snakes, List<int[]> ladders) {
        Board board = new Board(size);
        Set<Integer> starts = new HashSet<>();

        for (int[] s : snakes) {
            int start = s[0];
            int end = s[1];
            if (start <= 1 || start >= size) throw new IllegalArgumentException("Snake start out of range");
            if (end <= 1 || end >= size) throw new IllegalArgumentException("Snake end out of range");
            if (end >= start) throw new IllegalArgumentException("Snake must go down");
            if (!starts.add(start)) throw new IllegalArgumentException("Duplicate entity start: " + start);
            board.addEntity(new Snake(start, end));
        }

        for (int[] l : ladders) {
            int start = l[0];
            int end = l[1];
            if (start <= 1 || start >= size) throw new IllegalArgumentException("Ladder start out of range");
            if (end <= 1 || end >= size) throw new IllegalArgumentException("Ladder end out of range");
            if (end <= start) throw new IllegalArgumentException("Ladder must go up");
            if (!starts.add(start)) throw new IllegalArgumentException("Duplicate entity start: " + start);
            board.addEntity(new Ladder(start, end));
        }

        return board;
    }
}


