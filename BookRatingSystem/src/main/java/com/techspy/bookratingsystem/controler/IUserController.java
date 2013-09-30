/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler;

import com.techspy.bookratingsystem.model.RatingEnum;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Textbook;
import com.techspy.bookratingsystem.model.User;
import com.techspy.bookratingsystem.view.Title;

/**
 * Logs user in or creates a new user
 * @author drew
 */
public interface IUserController {
    /**
     * Logs the user in and publishes itself if successful
     * @param username The username
     * @param password the user's password
     */
    public void login(String username, String password);
    /**
     * Logs the current user out of the system.
     * Will persist the user data.  This method
     * should be called on logout or close of the
     * system.
     */
    public void logout();
    /**
     * Creates the user and adds it to the user
     * list.
     * @param username the user to add.
     * @param password the user's password
     */
    public void createUser(String username, String password);
    
    /**
     * gets the username of the currently logged in user
     * @return the username of the user
     */
    public String getUsername();
    /**
     * 
     * @return true if user has been logged on
     */
    public boolean isLoggedOn();
    
    public void addRating(Textbook title, RatingValue rating);
}
