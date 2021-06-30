package big_task3209_html_editor.listeners;

import big_task3209_html_editor.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(final View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(final MenuEvent e) {
        JMenu source = (JMenu) e.getSource();
        Component[] menuItems = source.getMenuComponents();
        for (Component item : menuItems) {
            item.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(final MenuEvent e) {

    }

    @Override
    public void menuCanceled(final MenuEvent e) {

    }
}
