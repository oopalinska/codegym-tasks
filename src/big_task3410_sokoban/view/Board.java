package big_task3410_sokoban.view;

import big_task3410_sokoban.controller.EventListener;
import big_task3410_sokoban.model.GameObject;
import big_task3410_sokoban.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Board extends JPanel {
    private View view;
    private EventListener eventListener;

    public Board(final View view) {
        this.view = view;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        GameObjects gameObjects = view.getGameObjects();
        Set<GameObject> all = gameObjects.getAll();
        for (GameObject gameObject : all) {
            gameObject.draw(g);
        }
    }
}

