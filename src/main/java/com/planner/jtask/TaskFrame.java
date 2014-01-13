package com.planner.jtask;


import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class TaskFrame extends JFrame {
    private MigLayout rootlayout;

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel firstTabPanel;

    private JTabbedPane tabbedPanel;

    private JButton jButtonL;
    private JButton jButtonR;

    public TaskFrame() {
        rootlayout = new MigLayout("", "[pref!][grow, fill]", "[]15[]");
        setLayout(rootlayout);
        addComponents();
        pack();
    }

    private void addComponents() {
        jButtonL = new JButton("Left");
        jButtonR = new JButton("Right");

        leftPanel = new JPanel();
        leftPanel.add(jButtonL);

        rightPanel = new JPanel();
        tabbedPanel = new JTabbedPane();
        firstTabPanel = new JPanel();
        firstTabPanel.add(jButtonR);
        tabbedPanel.addTab("title", firstTabPanel);
        rightPanel.add(tabbedPanel);
        add(leftPanel, "span 3");
        add(rightPanel, "wrap");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaskFrame taskFrame = new TaskFrame();
                taskFrame.setVisible(true);
                taskFrame.setSize(640, 480);   //TODO get system properties and divide on half
            }
        });
    }
}
