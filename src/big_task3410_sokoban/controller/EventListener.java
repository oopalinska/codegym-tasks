package big_task3410_sokoban.controller;

import big_task3410_sokoban.model.Direction;

public interface EventListener {
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}

