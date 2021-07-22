package big_task3513_2048_game;

public class MoveFitness {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveFitness(final int numberOfEmptyTiles, final int score, final Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }
}
