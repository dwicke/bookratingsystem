/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.model.User;

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
