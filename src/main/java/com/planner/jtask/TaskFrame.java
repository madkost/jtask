package com.planner.jtask;


import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class TaskFrame extends JFrame {
    private MigLayout rootlayout;

    private JPanel mainPanel;
    private JPanel sidePanel;

    private JButton jButtonL;
    private JButton jButtonR;

    public TaskFrame() {
        rootlayout = new MigLayout("", "[pref!][grow, fill]","[]15[]");
        setLayout(rootlayout);
        addComponents();
        pack();
    }

    private void addComponents(){
        jButtonL = new JButton("Left");
        jButtonR = new JButton("Right");

        add(jButtonL, "wrap");
        add(jButtonR);


    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskFrame().setVisible(true);
            }
        });
    }
}
