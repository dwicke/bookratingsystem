/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.view;

import com.google.common.eventbus.EventBus;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.model.RatingChangedMessage;
import com.techspy.bookratingsystem.model.RatingEnum;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Textbook;
import java.awt.Container;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author drew
 */
public class UserRated extends javax.swing.JPanel  implements StarRater.StarListener {

    private Map<RatingEnum, StarRater> ratings;
    private Textbook myText;
    /**
     * Creates new form UserRated
     */
    public UserRated() {
        initComponents();
        ratings = new EnumMap<RatingEnum, StarRater>(RatingEnum.class);
        ratings.put(RatingEnum.HELPFUL, helpfulRating);
        ratings.put(RatingEnum.CLARITY, clarityRating);
        ratings.put(RatingEnum.EASINESS, easinessRating);
        for(Map.Entry<RatingEnum, StarRater> r : ratings.entrySet()) {
            r.getValue().addStarListener(this);
            r.getValue().setID(r.getKey());
        }
    }

    public void updateRating(Textbook book) {
        myText = book;
        IUserController uc = Main.injector.getInstance(IUserController.class);
        List<RatingValue> rate = uc.getRatings(book);
        titleBt.setText(book.getTitle());
        for (RatingValue val : rate) {
            ratings.get(val.getRatingCategory()).setSelection(val.getTotal());
            System.err.println(val.getRatingCategory() + " " + ratings.get(val.getRatingCategory()).getSelection());
            //ratings.get(val.getRatingCategory()).repaint();
        }
        System.out.println("Updating the userRated rating");
        revalidate();
        invalidate();
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        helpfulRating = new com.techspy.bookratingsystem.view.StarRater();
        clarityRating = new com.techspy.bookratingsystem.view.StarRater();
        easinessRating = new com.techspy.bookratingsystem.view.StarRater();
        titleBt = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();

        titleBt.setText("jLabel1");

        deleteButton.setText("x");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleBt)
                .addGap(41, 41, 41)
                .addComponent(helpfulRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clarityRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(easinessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(deleteButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(clarityRating, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(helpfulRating, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(titleBt))
            .addComponent(deleteButton)
            .addComponent(easinessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        // TODO add your handling code here:
        IUserController uc = Main.injector.getInstance(IUserController.class);
        uc.deleteRating(myText);
        
        
    }//GEN-LAST:event_deleteButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techspy.bookratingsystem.view.StarRater clarityRating;
    private javax.swing.JButton deleteButton;
    private com.techspy.bookratingsystem.view.StarRater easinessRating;
    private com.techspy.bookratingsystem.view.StarRater helpfulRating;
    private javax.swing.JLabel titleBt;
    // End of variables declaration//GEN-END:variables

    public void handleSelection(int selection, RatingEnum id) {
        RatingChangedMessage message = new RatingChangedMessage(myText, new RatingValue(selection, 5, 5, id));
       
        // get the usercontroller and tell it that the user has rated the book this way.
        Main.injector.getInstance(IUserController.class).addRating(message.getBook(), message.getVal());
        // let the search view know about it so that 
        Main.injector.getInstance(EventBus.class).post(message);
    }
}
