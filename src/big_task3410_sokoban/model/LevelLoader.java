package big_task3410_sokoban.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(final Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<StorageLocation> storageLocations = new HashSet<>();
        Player player = null;

        int loopLevel;
        if (level > 60) {
            loopLevel = level % 60;
        } else {
            loopLevel = level;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            int readLevel = 0;
            int x;
            int y = GameObject.BOARD_CELL_SIZE / 2;
            boolean isLevelMap = false;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze:")) {
                    readLevel = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }
                if (readLevel == loopLevel) {
                    if (line.length() == 0) {
                        boolean isEnd = isLevelMap;

                        isLevelMap = !isLevelMap;

                        if (isEnd && !isLevelMap) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (isLevelMap) {
                        x = GameObject.BOARD_CELL_SIZE / 2;

                        char[] chars = line.toCharArray();
                        for (char c : chars) {
                            switch (c) {
                                case 'X':
                                    walls.add(new Wall(x, y));
                                    break;
                                case '*':
                                    boxes.add(new Box(x, y));
                                    break;
                                case '.':
                                    storageLocations.add(new StorageLocation(x, y));
                                    break;
                                case '&':
                                    boxes.add(new Box(x, y));
                                    storageLocations.add(new StorageLocation(x, y));
                                    break;
                                case '@':
                                    player = new Player(x, y);
                            }
                            x += GameObject.BOARD_CELL_SIZE;
                        }
                        y += GameObject.BOARD_CELL_SIZE;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, storageLocations, player);
    }
}

