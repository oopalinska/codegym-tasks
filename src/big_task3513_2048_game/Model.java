package big_task3513_2048_game;

import java.util.ArrayList;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

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
}