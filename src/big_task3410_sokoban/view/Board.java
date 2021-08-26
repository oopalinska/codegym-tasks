package big_task3410_sokoban.view;

import big_task3410_sokoban.controller.EventListener;

import javax.swing.*;
import java.awt.*;

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
    }
}

