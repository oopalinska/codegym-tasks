package big_task3513_2048_game;

import java.util.ArrayList;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score = 0;
    int maxTile = 0;

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        ArrayList<Tile> emptyTiles = getEmptyTiles();
        int randomTile = (int) (emptyTiles.size() * Math.random());
        int newTileWeight = Math.random() < 0.9 ? 2 : 4;
        emptyTiles.get(randomTile).value = newTileWeight;
    }
    private ArrayList<Tile> getEmptyTiles() {
        ArrayList<Tile> resultList = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    resultList.add(gameTiles[i][j]);
                }
            }
        return resultList;
    }

    private void consolidateTiles(Tile[] tiles) {
        int insertPosition = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (!tiles[i].isEmpty()) {
                if (insertPosition != i) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                }
                insertPosition++;
            }
        }
    }

    private void mergeTiles(Tile[] tiles) {
        ArrayList<Tile> tilesList = new ArrayList<>();
        for (int i = 0; i < tiles.length-1; i++) {
            if (tiles[i].isEmpty()) {
                continue;
            }
            int currentTileValue = tiles[i].value;
            if (currentTileValue == tiles[i + 1].value) {
                currentTileValue = 2 * tiles[i].value;
                score += currentTileValue;
                if (currentTileValue > maxTile) {
                    maxTile = currentTileValue;
                }
                tilesList.add(new Tile(currentTileValue));
                tiles[i + 1].value = 0;
            } else {
                tilesList.add(new Tile(currentTileValue));
            }
            tiles[i].value = 0;
        }
        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i] = tilesList.get(i);
        }
    }
}
