/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.view;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.model.RemoveUserTextbookMessage;
import com.techspy.bookratingsystem.model.Textbook;
import java.awt.GridLayout;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author drew
 */
public class UserRatedPane extends javax.swing.JPanel {

    Map<Textbook, UserRated> updateMap;
    
    /**
     * Creates new form UserRatedPane
     */
    public UserRatedPane() {
        initComponents();
        Main.injector.getInstance(EventBus.class).register(this);// register this to receive events
        updateMap = new TreeMap<Textbook, UserRated>();
        
        userRatedPanel.setLayout(new GridLayout(0, 1));
    }

    @Subscribe public void updateRating(Textbook title) {
        System.out.println("User profile is updating ratings");
        
        if (updateMap.containsKey(title)) {
            updateMap.get(title);
            updateMap.get(title).updateRating(title);
        }
        else {
            //((GridLayout)userRatedPanel.getLayout()).setRows(updateMap.size() + 1);
            UserRated ur = new UserRated();
            ur.updateRating(title);
            updateMap.put(title, ur);
            userRatedPanel.add(ur);
        }
        revalidate();
        invalidate();
        repaint();
    }
    
    @Subscribe public void removeRating(RemoveUserTextbookMessage textbookRating) {
        System.out.println("User profile is removing ratings");
        
        userRatedPanel.remove(updateMap.get(textbookRating.getBook()));
        updateMap.remove(textbookRating.getBook());
        userRatedPanel.invalidate();
        userRatedPanel.revalidate();
        userRatedPanel.repaint();
    }
    
    @Subscribe public void userChange(IUserController ucontrol) {
        if (!ucontrol.isLoggedOn()) {
            updateMap.clear();
            userRatedPanel.removeAll();
            userRatedPanel.validate();
            userRatedPanel.repaint();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        userRatedPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout userRatedPanelLayout = new javax.swing.GroupLayout(userRatedPanel);
        userRatedPanel.setLayout(userRatedPanelLayout);
        userRatedPanelLayout.setHorizontalGroup(
            userRatedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        userRatedPanelLayout.setVerticalGroup(
            userRatedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(userRatedPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel userRatedPanel;
    // End of variables declaration//GEN-END:variables
}
