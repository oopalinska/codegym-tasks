package big_task3209_html_editor;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {

    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem newJMenuItem = new JMenuItem(text);
        newJMenuItem.addActionListener(actionListener);
        parent.add(newJMenuItem);
        return newJMenuItem;
    }
    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem newJMenuItem = addMenuItem(parent, action);
        newJMenuItem.setText(text);
        return newJMenuItem;
    }
    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem newJMenuItem = new JMenuItem(action);
        parent.add(newJMenuItem);
        return newJMenuItem;
    }
    public static void initHelpMenu(View view, JMenuBar menuBar) {}
    public static void initFontMenu(View view, JMenuBar menuBar) {}
    public static void initColorMenu(View view, JMenuBar menuBar) {}
    public static void initAlignMenu(View view, JMenuBar menuBar) {}
    public static void initStyleMenu(View view, JMenuBar menuBar) {}
    public static void initEditMenu(View view, JMenuBar menuBar) {}
    public static void initFileMenu(View view, JMenuBar menuBar) {}
}
