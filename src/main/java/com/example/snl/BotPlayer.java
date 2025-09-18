package com.example.snl;

import java.util.Objects;

public class BotPlayer implements Player {
    private final String id;
    private final String name;

    public BotPlayer(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBot() {
        return true;
    }
}


