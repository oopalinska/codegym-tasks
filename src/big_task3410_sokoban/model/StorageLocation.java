package big_task3410_sokoban.model;

import java.awt.*;

public class StorageLocation extends GameObject {

    public StorageLocation(final int x, final int y) {
        super(x, y);
        this.width = 2;
        this.height = 2;
    }

    @Override
    public void draw(final Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawOval(x - width / 2, y - height / 2, width, height);
    }
}
