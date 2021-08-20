package big_task3410_sokoban.controller;

import big_task3410_sokoban.model.Model;
import big_task3410_sokoban.view.View;

public class Controller {
    private View view;
    private Model model;

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
    }

    public static void main(String[] args) {

    }
}
