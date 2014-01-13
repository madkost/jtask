/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planner.jtask;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author xxx
 */
public class GraphFrame extends javax.swing.JFrame {
    
    private mxGraph graph;
    private int counter = 0;
    private Object previous;

    /**
     * Creates new form GraphFrame
     */
    public GraphFrame() {
        initComponents();
        rootPanel.setLayout(new FlowLayout());
        createGraph();
        displayGraph();
        this.pack();
        
    }
    
    private void createGraph() {
        graph = new mxGraph();
    }
    
    private void displayGraph() {
        Object parent = graph.getDefaultParent();
        
        graph.getModel().beginUpdate();
        try {
            Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
                    30);
            Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
                    80, 30);
            graph.insertEdge(parent, null, "Edge", v1, v2);
        } finally {
            graph.getModel().endUpdate();
        }
        
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        rootPanel.add(graphComponent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootSplitPane = new javax.swing.JSplitPane();
        sideBarSplitPane = new javax.swing.JSplitPane();
        sideBarTopPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        sideBarBottonPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        rootPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rootSplitPane.setDividerLocation(300);
        rootSplitPane.setDividerSize(5);

        sideBarSplitPane.setDividerSize(5);
        sideBarSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarTopPanelLayout = new javax.swing.GroupLayout(sideBarTopPanel);
        sideBarTopPanel.setLayout(sideBarTopPanelLayout);
        sideBarTopPanelLayout.setHorizontalGroup(
            sideBarTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarTopPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        sideBarTopPanelLayout.setVerticalGroup(
            sideBarTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarTopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sideBarSplitPane.setTopComponent(sideBarTopPanel);

        infoLabel.setText("info");

        javax.swing.GroupLayout sideBarBottonPanelLayout = new javax.swing.GroupLayout(sideBarBottonPanel);
        sideBarBottonPanel.setLayout(sideBarBottonPanelLayout);
        sideBarBottonPanelLayout.setHorizontalGroup(
            sideBarBottonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarBottonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        sideBarBottonPanelLayout.setVerticalGroup(
            sideBarBottonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarBottonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        sideBarSplitPane.setRightComponent(sideBarBottonPanel);

        rootSplitPane.setRightComponent(sideBarSplitPane);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        rootSplitPane.setLeftComponent(rootPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootSplitPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootSplitPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Object parent = graph.getDefaultParent();
        
        graph.getModel().beginUpdate();
        try {
            int x = rootPanel.getHeight();
            int y = rootPanel.getWidth();
            x = new Random().nextInt(x) -100;
            y = new Random().nextInt(y) -50;
            
            Object obj = graph.insertVertex(parent, null, counter + " node", x, y, 80,
                    30);
            graph.insertEdge(parent, null, counter, obj, previous);
            previous = obj;
            
        } finally {
            graph.getModel().endUpdate();
            infoLabel.setText(counter + " nodes");
            counter++;
        }
        pack();
//        mxGraphComponent graphComponent = new mxGraphComponent(graph);
//        rootPanel.add(graphComponent);
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JSplitPane rootSplitPane;
    private javax.swing.JPanel sideBarBottonPanel;
    private javax.swing.JSplitPane sideBarSplitPane;
    private javax.swing.JPanel sideBarTopPanel;
    // End of variables declaration//GEN-END:variables

}
