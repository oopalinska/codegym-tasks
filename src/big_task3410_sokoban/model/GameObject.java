package big_task3410_sokoban.model;

import java.awt.*;

public abstract class GameObject {
    public static int BOARD_CELL_SIZE = 20;
    int x;
    int y;
    int width;
    int height;

    public GameObject(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.width = BOARD_CELL_SIZE;
        this.height = BOARD_CELL_SIZE;
    }

    public GameObject(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public abstract void draw(Graphics graphics);
}