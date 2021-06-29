package big_task3209_html_editor.listeners;

import big_task3209_html_editor.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameListener extends WindowAdapter {
    private View view;

    public FrameListener(final View view) {
        this.view = view;
    }

    @Override
    public void windowClosing(final WindowEvent e) {
        super.windowClosing(e);
        view.exit();
    }
}
