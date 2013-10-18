/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IRatingController;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Textbook;
import com.techspy.bookratingsystem.model.User;
import com.techspy.bookratingsystem.view.Main;
import com.techspy.bookratingsystem.view.Title;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Log a user in and publish this when login is complete
 * @author drew
 */
public class UserController implements IUserController{

    private User theUser;
    private EventBus bus;
    private boolean loggedOn;
    
    
    @Inject public UserController(EventBus bus) {
        this.bus = bus;
        theUser = new User();
        
        loggedOn = false;
    }
    
    /**
     * Adds the rating and posts the title that was rated.
     * @param title
     * @param rating 
     */
    public void addRating(Textbook title, RatingValue rating) {
        if (loggedOn) {
            IRatingController rc = Main.injector.getInstance(IRatingController.class);
            if (theUser.getRatings().containsKey(title)) {
                List<RatingValue> vals = theUser.getRatings().get(title);
                if(vals.contains(rating)) {
                    // make the necessary lists
                    List<RatingValue> newVal = new ArrayList<RatingValue>();
                    newVal.add(rating);
                    List<RatingValue> oldVal = new ArrayList<RatingValue>();
                    oldVal.add(vals.get(vals.indexOf(rating)));
                    // first subtract the previous rating
                    rc.removeRating(title, oldVal);
                    // then add the new rating
                    rc.addRating(title, newVal);
                    // update this
                    vals.get(vals.indexOf(rating)).update(rating);
                }else {
                    // need to add the rating
                    vals.add(rating);
                    List<RatingValue> newVal = new ArrayList<RatingValue>();
                    newVal.add(rating);
                    rc.addRating(title, newVal);
                }
            } else {
                ArrayList<RatingValue> vals = new ArrayList<RatingValue>();
                vals.add(rating);
                theUser.getRatings().put(title, vals);
                rc.addRating(title, vals);
            }
            
            
            
            bus.post(title);
        }
    }
    
    
    
    public void login(String username, String password) {
        theUser.clear();
        theUser.setUname(username);
        theUser.setPass(password);
        loggedOn = true;
        bus.post(this);
    }

    public void logout() {
        theUser.clear();
        loggedOn = false;
        
        bus.post(this);
    }

    public void createUser(String username, String password) {
        theUser.clear();
        theUser.setUname(username);
        theUser.setPass(password);
        loggedOn = true;
        
        bus.post(this);
    }

    public String getUsername() {
        return theUser.getUname();
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public List<RatingValue> getRatings(Textbook title) {
        return theUser.getRatings().get(title);
    }

    public void deleteRating(Textbook title) {
        // must remove the rating from ratingcontroller
        Main.injector.getInstance(IRatingController.class).removeRating(title, theUser.getRatings().get(title));
        theUser.getRatings().remove(title);
        
    }
    
}
