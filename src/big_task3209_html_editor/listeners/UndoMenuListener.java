package big_task3209_html_editor.listeners;

import big_task3209_html_editor.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(final View view, final JMenuItem undoMenuItem, final JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(final MenuEvent e) {
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());

    }

    @Override
    public void menuDeselected(final MenuEvent e) {

    }

    @Override
    public void menuCanceled(final MenuEvent e) {

    }
}
