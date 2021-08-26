package big_task3410_sokoban.view;

import big_task3410_sokoban.controller.Controller;
import big_task3410_sokoban.controller.EventListener;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Board board;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void setEventListener(EventListener eventListener) {
        board.setEventListener(eventListener);
    }

    public void init() {
        board = new Board(this);
        add(board);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Sokoban");
        setVisible(true);
    }
}
