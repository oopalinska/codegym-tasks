package big_task3410_sokoban.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(final int x, final int y) {
        super(x, y);
    }

    @Override
    public void move(final int x, final int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw(final Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawRect(x - width / 2, y - height / 2, width, height);
    }
}

