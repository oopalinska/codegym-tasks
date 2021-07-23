package big_task3513_2048_game;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score = 0;
    int maxTile = 0;
    private final Stack<Tile[][]> previousStates = new Stack<>();
    private final Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

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
        if (!emptyTiles.isEmpty()) {
            int randomTile = (int) (emptyTiles.size() * Math.random());
            int newTileWeight = Math.random() < 0.9 ? 2 : 4;
            emptyTiles.get(randomTile).value = newTileWeight;
        }
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

    private boolean consolidateTiles(Tile[] tiles) {
        boolean result = false;
        int insertPosition = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (!tiles[i].isEmpty()) {
                if (insertPosition != i) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean result = false;
        LinkedList<Tile> tilesList = new LinkedList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].isEmpty()) {
                continue;
            }

            if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i + 1].value) {
                int updatedValue = tiles[i].value * 2;
                if (updatedValue > maxTile) {
                    maxTile = updatedValue;
                }
                score += updatedValue;
                tilesList.addLast(new Tile(updatedValue));
                tiles[i + 1].value = 0;
                result = true;
            } else {
                tilesList.addLast(new Tile(tiles[i].value));
            }
            tiles[i].value = 0;
        }
        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i] = tilesList.get(i);
        }
        return result;
    }
    private Tile[][] rotateClockwise(Tile[][] tiles) {
        final int N = tiles.length;
        Tile[][] result = new Tile[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                result[c][N-1-r] = tiles[r][c];
            }
        }
        return result;
    }
    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean shouldAdd = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (consolidateTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                shouldAdd = true;
            }
        }
        if (shouldAdd) {
            addTile();
        }
        isSaveNeeded = false;
    }
    public void right() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    boolean canMove() {
        if (getEmptyTiles().size() != 0) {
            return true;
        }

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = gameTiles[i][j];
                if ((i < FIELD_WIDTH - 1 && tile.value == gameTiles[i + 1][j].value)
                        || ((j < FIELD_WIDTH - 1) && tile.value == gameTiles[i][j + 1].value)) {
                    return true;
                }
            }
        }
        return false;
    }
    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }
    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }
    public void randomMove() {
        int n = ((int) (Math.random () * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }
    private boolean hasBoardChanged() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value != previousStates.peek()[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }
    public MoveFitness getMoveFitness(Move move) {
        MoveFitness moveFitness = new MoveFitness(-1, 0, move);
        move.move();
        if (hasBoardChanged()) {
            moveFitness = new MoveFitness(getEmptyTiles().size(), score, move);
        }
        rollback();
        return moveFitness;
    }
    public void autoMove() {
        PriorityQueue<MoveFitness> moves = new PriorityQueue<>(4, Collections.reverseOrder());
        moves.add(getMoveFitness(this::left));
        moves.add(getMoveFitness(this::up));
        moves.add(getMoveFitness(this::right));
        moves.add(getMoveFitness(this::down));

        moves.peek().getMove().move();

    }
}