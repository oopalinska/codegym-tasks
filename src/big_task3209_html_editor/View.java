package big_task3209_html_editor;

import big_task3209_html_editor.listeners.FrameListener;
import big_task3209_html_editor.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        this.setVisible(true);
    }
    public void exit() {
        controller.exit();
    }
    @Override
    public void actionPerformed(final ActionEvent e) {

    }
    public void initMenuBar() {}
    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", htmlScrollPane);

        JScrollPane plainScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Text", plainScrollPane);

        tabbedPane.setPreferredSize(new Dimension(300,300));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(final Controller controller) {
        this.controller = controller;
    }

    public void selectedTabChanged() {

    }
}
