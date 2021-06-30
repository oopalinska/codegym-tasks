package big_task3209_html_editor.actions;

import big_task3209_html_editor.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractAction {
    private View view;

    public RedoAction(final View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        view.redo();
    }
}
