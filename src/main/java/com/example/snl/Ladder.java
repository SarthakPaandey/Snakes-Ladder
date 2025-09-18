package com.example.snl;

public class Ladder implements BoardEntity {
    private final int start;
    private final int end;

    public Ladder(int start, int end) {
        if (end <= start) {
            throw new IllegalArgumentException("Ladder must go up: end > start");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public int apply(int currentPosition) {
        return end;
    }
}


