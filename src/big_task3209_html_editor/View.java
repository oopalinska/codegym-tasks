package big_task3209_html_editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;

    public void init() {}
    public void exit() {
        controller.exit();
    }
    @Override
    public void actionPerformed(final ActionEvent e) {

    }

    public Controller getController() {
        return controller;
    }

    public void setController(final Controller controller) {
        this.controller = controller;
    }
}
