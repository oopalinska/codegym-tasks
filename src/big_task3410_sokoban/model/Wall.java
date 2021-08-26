package big_task3410_sokoban.model;

import java.awt.*;

public class Wall extends CollisionObject {

    public Wall(final int x, final int y) {
        super(x, y);
    }

    @Override
    public void draw(final Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(x - width / 2, y - height / 2, width, height);
    }
}

