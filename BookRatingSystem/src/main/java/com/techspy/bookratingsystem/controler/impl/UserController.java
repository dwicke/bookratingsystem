/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.User;
import com.techspy.bookratingsystem.view.Title;
import java.util.ArrayList;
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
    private Map<Title, List<RatingValue> > ratings;
    
    @Inject public UserController(EventBus bus) {
        this.bus = bus;
        theUser = new User();
        ratings = new TreeMap<Title, List<RatingValue>>();
        loggedOn = false;
    }
    
    public void addRating(Title title, RatingValue rating) {
        if (ratings.containsKey(title)) {
            List<RatingValue> vals = ratings.get(title);
            if(vals.contains(rating)) {
                vals.get(vals.indexOf(rating)).update(rating);
            }
        } else {
            ArrayList<RatingValue> vals = new ArrayList<RatingValue>();
            vals.add(rating);
            ratings.put(title, vals);
        }
    }
    public void login(String username, String password) {
        
        theUser.setUname(username);
        theUser.setPass(password);
        loggedOn = true;
        
        bus.post(this);
    }

    public void logout() {
        theUser.setUname("");
        theUser.setPass("");
        loggedOn = false;
        bus.post(this);
    }

    public void createUser(String username, String password) {
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
    
}
