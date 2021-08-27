package big_task3410_sokoban.model;

import big_task3410_sokoban.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Model {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader;

    public Model() {
        try {
            this.levelLoader = new LevelLoader(Paths.get(getClass().getResource("../res/levels.txt").toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void restartLevel(final int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void move(final Direction direction) {

    }
}
