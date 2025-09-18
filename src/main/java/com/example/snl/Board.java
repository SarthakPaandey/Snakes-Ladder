package com.example.snl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, BoardEntity> entitiesByStart;
    private final Map<String, Integer> playerPositions;
    private final Map<String, Player> playersById;

    public Board(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Board size must be > 1");
        }
        this.size = size;
        this.entitiesByStart = new HashMap<>();
        this.playerPositions = new HashMap<>();
        this.playersById = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void registerPlayer(Player player) {
        playersById.put(player.getId(), player);
        playerPositions.putIfAbsent(player.getId(), 0);
    }

    public void addEntity(BoardEntity entity) {
        if (entity.getStart() <= 1 || entity.getStart() >= size) {
            throw new IllegalArgumentException("Entity start must be within 2..size-1");
        }
        if (entitiesByStart.containsKey(entity.getStart())) {
            throw new IllegalArgumentException("Another entity already starts at " + entity.getStart());
        }
        if (entity.getEnd() <= 1 || entity.getEnd() >= size) {
            throw new IllegalArgumentException("Entity end must be within 2..size-1");
        }
        entitiesByStart.put(entity.getStart(), entity);
    }

    public BoardEntity getEntityAt(int position) {
        return entitiesByStart.get(position);
    }

    public int getPosition(Player player) {
        return playerPositions.getOrDefault(player.getId(), 0);
    }

    public void setPosition(Player player, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Position out of bounds: " + position);
        }
        playerPositions.put(player.getId(), position);
    }

    public boolean isOccupied(int position) {
        return playerPositions.values().stream().anyMatch(p -> p == position);
    }

    public List<Player> getPlayersAt(int position) {
        List<Player> occupants = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : playerPositions.entrySet()) {
            if (entry.getValue() == position) {
                Player player = playersById.get(entry.getKey());
                if (player != null) {
                    occupants.add(player);
                }
            }
        }
        return occupants;
    }

    public int applyEntities(int position) {
        BoardEntity entity = getEntityAt(position);
        if (entity == null) {
            return position;
        }
        return entity.apply(position);
    }
}


