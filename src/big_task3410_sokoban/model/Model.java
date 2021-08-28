package big_task3410_sokoban.model;

import big_task3410_sokoban.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static big_task3410_sokoban.model.GameObject.BOARD_CELL_SIZE;

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

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (wall.isCollision(gameObject, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        for (Box box : gameObjects.getBoxes()) {
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                for (Box nextBox : gameObjects.getBoxes()) {
                    if (!nextBox.equals(box) && box.isCollision(nextBox, direction)) {
                        return true;
                    }
                }
                if (checkWallCollision(box, direction)) {
                    return true;
                }
            }
            int dx = direction == Direction.LEFT ? -BOARD_CELL_SIZE : (direction == Direction.RIGHT ? BOARD_CELL_SIZE : 0);
            int dy = direction == Direction.UP ? -BOARD_CELL_SIZE : (direction == Direction.DOWN ? BOARD_CELL_SIZE : 0);
            box.move(dx, dy);
        }
        return false;
    }
}
