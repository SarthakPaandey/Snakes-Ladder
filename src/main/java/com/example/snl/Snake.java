package com.example.snl;

public class Snake implements BoardEntity {
    private final int start;
    private final int end;

    public Snake(int start, int end) {
        if (end >= start) {
            throw new IllegalArgumentException("Snake must go down: end < start");
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


