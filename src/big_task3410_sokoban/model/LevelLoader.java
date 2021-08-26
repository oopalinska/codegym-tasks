package big_task3410_sokoban.model;

import java.nio.file.Path;
import java.util.HashSet;

public class LevelLoader {
    private Path levels;

    public LevelLoader(final Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        HashSet<Wall> walls = new HashSet<>();
        walls.add(new Wall(20,40));
        walls.add(new Wall(20,60));
        walls.add(new Wall(20,80));
        HashSet<Box> boxes = new HashSet<>();
        boxes.add(new Box(40, 60));
        HashSet<StorageLocation> storageLocations = new HashSet<>();
        storageLocations.add(new StorageLocation(40, 80));
        Player player = new Player(60, 40);
        return new GameObjects(walls, boxes, storageLocations, player);
    }
}

