package big_task3410_sokoban.view;

import big_task3410_sokoban.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;

    public View(final Controller controller) throws HeadlessException {
        this.controller = controller;
    }
}

