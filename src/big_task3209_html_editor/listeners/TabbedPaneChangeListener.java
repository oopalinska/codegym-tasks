package big_task3209_html_editor.listeners;

import big_task3209_html_editor.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPaneChangeListener implements ChangeListener {
    private View view;

    public TabbedPaneChangeListener(final View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(final ChangeEvent e) {
        view.selectedTabChanged();
    }
}
