package big_task3410_sokoban.controller;

import big_task3410_sokoban.model.Direction;
import big_task3410_sokoban.model.Model;
import big_task3410_sokoban.view.View;

public class Controller implements EventListener {
    private View view;
    private Model model;

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
        view.init();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    @Override
    public void move(final Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(final int level) {

    }
}
