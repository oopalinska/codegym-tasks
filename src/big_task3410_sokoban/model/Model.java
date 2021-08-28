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
        if (checkWallCollision(gameObjects.getPlayer(), direction)) {
            return;
        }
        if (checkBoxCollisionAndMoveIfAvailable(direction)) {
            return;
        }
        int dx = direction == Direction.LEFT ? -BOARD_CELL_SIZE : (direction == Direction.RIGHT ? BOARD_CELL_SIZE : 0);
        int dy = direction == Direction.UP ? -BOARD_CELL_SIZE : (direction == Direction.DOWN ? BOARD_CELL_SIZE : 0);
        gameObjects.getPlayer().move(dx, dy);

        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
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
                    if (checkWallCollision(box, direction)) {
                        return true;
                    }
                }
                int dx = direction == Direction.LEFT ? -BOARD_CELL_SIZE : (direction == Direction.RIGHT ? BOARD_CELL_SIZE : 0);
                int dy = direction == Direction.UP ? -BOARD_CELL_SIZE : (direction == Direction.DOWN ? BOARD_CELL_SIZE : 0);
                box.move(dx, dy);
            }
        }
        return false;
    }

    public void checkCompletion() {
        int storageLocationsCount = gameObjects.getStorageLocations().size();
        int busyStorageLocationsCount = 0;

        for (StorageLocation storageLocation : gameObjects.getStorageLocations()) {
            for (Box box : gameObjects.getBoxes()) {
                if (storageLocation.getX() == box.getX() && storageLocation.getY() == box.getY()) {
                    busyStorageLocationsCount++;
                }
            }
        }

        if (storageLocationsCount == busyStorageLocationsCount) {
            eventListener.levelCompleted(currentLevel);
        }
    }
}