/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.view;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.model.Textbook;
import com.techspy.bookratingsystem.model.User;

/**
 *
 * @author drew
 */
public class UserProfile extends javax.swing.JPanel {

    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        initComponents();
        Main.injector.getInstance(EventBus.class).register(this);// register this to receive events
    }

    
    @Subscribe public void setUser(IUserController user) {
        // I will get a message even when logging out so that I can
        // be set to ""
        if (user.isLoggedOn()) {
        welcomeLabel.setText("<html><h2>Welcome: " + user.getUsername() + "</h2></html>");
        welcomeLabel.repaint();
        }
        else {
            welcomeLabel.setText("");
            welcomeLabel.repaint();
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        userRatedPane1 = new com.techspy.bookratingsystem.view.UserRatedPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logoutBt = new javax.swing.JButton();

        welcomeLabel.setText("Welcome:");

        jLabel1.setText("Helpfulness");

        jLabel2.setText("Clarity");

        jLabel3.setText("Easiness");

        logoutBt.setText("Logout");
        logoutBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userRatedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(welcomeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoutBt)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoutBt)
                .addGap(16, 16, 16)
                .addComponent(welcomeLabel)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userRatedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtActionPerformed
        // TODO add your handling code here:
        IUserController ucon = Main.injector.getInstance(IUserController.class);
        ucon.logout();
    }//GEN-LAST:event_logoutBtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logoutBt;
    private com.techspy.bookratingsystem.view.UserRatedPane userRatedPane1;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
