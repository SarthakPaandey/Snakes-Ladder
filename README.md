## Snake & Ladder - Design and Class Diagram

This project implements a flexible, strategy-driven Snake & Ladder game in Java.

### Goals
- **Extensible rules** via strategies (start, move, occupied cell, special turn, win)
- **Pluggable board** creation (factories) with proper snake/ladder placement
- **Clear engine** handling turn management, dice rolling, collisions, and win conditions

### Class Diagram (high level)

```mermaid
classDiagram
    class Game {
      -Board board
      -List~Player~ players
      -Dice dice
      -RuleSet rules
      +play(): void
    }

    class Board {
      -int size
      -Map~int, BoardEntity~ entitiesByStart
      -Map~String, Integer~ playerPositions
      +addEntity(BoardEntity): void
      +getEntityAt(int): BoardEntity
      +getPosition(Player): int
      +setPosition(Player, int): void
      +applyEntities(int): int
      +isOccupied(int): boolean
      +getPlayerAt(int): Player
    }

    class Dice {
      -int sides
      -Random random
      +getInstance(): Dice
      +roll(): int
    }

    class RuleSet {
      +getStartingRule(): StartingRule
      +getMoveRule(): MoveRule
      +getOccupiedCellRule(): OccupiedCellRule
      +getSpecialTurnRule(): SpecialTurnRule
      +getWinRule(): WinRule
    }

    class Player {
      <<interface>>
      +getId(): String
      +getName(): String
      +isBot(): boolean
    }
    class HumanPlayer
    class BotPlayer
    Player <|.. HumanPlayer
    Player <|.. BotPlayer

    class BoardEntity {
      <<interface>>
      +getStart(): int
      +getEnd(): int
      +apply(int): int
    }
    class Snake
    class Ladder
    BoardEntity <|.. Snake
    BoardEntity <|.. Ladder

    Game --> Board
    Game --> Dice
    Game --> RuleSet
    Board --> BoardEntity
    Board --> Player

    class StartingRule {
      <<interface>>
      +canEnterBoard(currentPosition: int, roll: int): boolean
    }
    class MoveRule {
      <<interface>>
      +computeTarget(board: Board, player: Player, currentPosition: int, roll: int): int
    }
    class OccupiedCellRule {
      <<interface>>
      +resolve(board: Board, mover: Player, newPosition: int): void
    }
    class SpecialTurnRule {
      <<interface>>
      +decide(rolls: List~Integer~): Decision
    }
    class WinRule {
      <<interface>>
      +hasWon(position: int, boardSize: int): boolean
    }
    RuleSet --> StartingRule
    RuleSet --> MoveRule
    RuleSet --> OccupiedCellRule
    RuleSet --> SpecialTurnRule
    RuleSet --> WinRule
```

### Default Rule Set
- **Starting**: must roll a 6 to leave start (position 0)
- **Movement**: exact finish required; overshoot cancels the move for that roll
- **Occupied cell**: landing on an occupied cell sends the occupant back to start
- **Special turn**: roll a 6 for an extra roll; three 6s in a row cancels the entire turn (revert to start of turn)
- **Win**: first player to reach the final cell wins

### Board Creation
`BoardFactory` places snakes and ladders with constraints:
- Valid ranges (no starts at 1 or final cell)
- Directional validity (ladder goes up, snake goes down)
- Unique starts per entity

### Run
`Main` demonstrates a standard game with two players and the default rules.


