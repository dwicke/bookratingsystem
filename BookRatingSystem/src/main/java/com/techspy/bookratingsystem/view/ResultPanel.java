/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.view;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.controler.impl.UserController;
import com.techspy.bookratingsystem.model.RatingEnum;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Result;
import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * This is the view for a single textbook result.
 * @author drew
 */
public class ResultPanel extends javax.swing.JPanel implements StarRater.StarListener{

    private Result myResult;
    Map<RatingEnum, StarRater> ratings;
    Map<RatingEnum, StarRater> uratings;
    
    /**
     * Creates new form ResultPanel
     */
    public ResultPanel() {
        initComponents();
        userClarityRating.setVisible(false);
        userEasinessRating.setVisible(false);
        userHelpfulnessRating.setVisible(false);
        ratings = new EnumMap<RatingEnum, StarRater>(RatingEnum.class);
        ratings.put(RatingEnum.HELPFUL, helpfulnessRating);
        ratings.put(RatingEnum.CLARITY, clarityRating);
        ratings.put(RatingEnum.EASINESS, easinessRating);
        ratings.put(RatingEnum.OVERALL, overallRating);
        uratings = new EnumMap<RatingEnum, StarRater>(RatingEnum.class);
        uratings.put(RatingEnum.HELPFUL, userHelpfulnessRating);
        uratings.put(RatingEnum.CLARITY, userClarityRating);
        uratings.put(RatingEnum.EASINESS, userEasinessRating);
        Main.injector.getInstance(EventBus.class).register(this);
        for(StarRater r : uratings.values()) {
            r.addStarListener(this);
        }
        lbRateit.setVisible(false);
    }

    
    public void setResult(Result res) {
        myResult = res;
        // draw it
        lbAuthor.setText("Author: " + res.getBook().getAuthor());
        lbTitle.setText("Title: " + res.getBook().getTitle());
        for (RatingValue rate : res.getRatings()) {
            ratings.get(rate.getRatingCategory()).setRating(rate.getRating());
        }
        
    }
    
    @Subscribe public void updateUser(IUserController uControl) {
        for(StarRater r : uratings.values()) {
            r.setVisible(true);
        }
        lbRateit.setVisible(true);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clarityRating = new com.techspy.bookratingsystem.view.StarRater();
        easinessRating = new com.techspy.bookratingsystem.view.StarRater();
        helpfulnessRating = new com.techspy.bookratingsystem.view.StarRater();
        overallRating = new com.techspy.bookratingsystem.view.StarRater();
        lbTitle = new javax.swing.JLabel();
        lbAuthor = new javax.swing.JLabel();
        userHelpfulnessRating = new com.techspy.bookratingsystem.view.StarRater();
        userClarityRating = new com.techspy.bookratingsystem.view.StarRater();
        userEasinessRating = new com.techspy.bookratingsystem.view.StarRater();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbRateit = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        clarityRating.setToolTipText("Clarity Rating");
        clarityRating.setEnabled(false);

        easinessRating.setToolTipText("Easiness Rating");
        easinessRating.setEnabled(false);

        helpfulnessRating.setToolTipText("Helpfulness Rating");
        helpfulnessRating.setEnabled(false);

        overallRating.setToolTipText("Overall Rating (average of all ratings)");
        overallRating.setEnabled(false);

        lbTitle.setText("Title:");

        lbAuthor.setText("Author:");

        jLabel1.setText("Helpfulness");

        jLabel2.setText("Clarity");

        jLabel3.setText("Easiness");

        jLabel4.setText("Overall:");

        lbRateit.setText("Rate it:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAuthor)
                            .addComponent(lbTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(99, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(overallRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbRateit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userHelpfulnessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpfulnessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userClarityRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userEasinessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clarityRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(easinessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addComponent(helpfulnessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(easinessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clarityRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(overallRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addComponent(lbAuthor)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userClarityRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userHelpfulnessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userEasinessRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRateit))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techspy.bookratingsystem.view.StarRater clarityRating;
    private com.techspy.bookratingsystem.view.StarRater easinessRating;
    private com.techspy.bookratingsystem.view.StarRater helpfulnessRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbAuthor;
    private javax.swing.JLabel lbRateit;
    private javax.swing.JLabel lbTitle;
    private com.techspy.bookratingsystem.view.StarRater overallRating;
    private com.techspy.bookratingsystem.view.StarRater userClarityRating;
    private com.techspy.bookratingsystem.view.StarRater userEasinessRating;
    private com.techspy.bookratingsystem.view.StarRater userHelpfulnessRating;
    // End of variables declaration//GEN-END:variables

    /**
     * handles the selections of the user selections
     * @param selection
     * @param id 
     */
    public void handleSelection(int selection, RatingEnum id) {
       
    }
}
