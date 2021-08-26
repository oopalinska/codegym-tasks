package big_task3410_sokoban.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<StorageLocation> storageLocations;
    private Player player;

    public GameObjects(final Set<Wall> walls, final Set<Box> boxes, final Set<StorageLocation> storageLocations, final Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.storageLocations = storageLocations;
        this.player = player;
    }

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<StorageLocation> getStorageLocations() {
        return storageLocations;
    }

    public Player getPlayer() {
        return player;
    }

    public Set<GameObject> getAll() {
        HashSet<GameObject> result = new HashSet<>();
        result.addAll(walls);
        result.addAll(boxes);
        result.addAll(storageLocations);
        result.add(player);
        return result;
    }
}
