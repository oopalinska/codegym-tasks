package big_task3410_sokoban.model;

public abstract class CollisionObject extends GameObject {

    public CollisionObject(final int x, final int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case LEFT:
                return (this.x - BOARD_CELL_SIZE == gameObject.x && this.y == gameObject.y);
            case RIGHT:
                return (this.x + BOARD_CELL_SIZE == gameObject.x && this.y == gameObject.y);
            case UP:
                return (this.x == gameObject.x && this.y - BOARD_CELL_SIZE == gameObject.y);
            case DOWN:
                return (this.x == gameObject.x && this.y + BOARD_CELL_SIZE == gameObject.y);
        }
        return false;
    }
}
