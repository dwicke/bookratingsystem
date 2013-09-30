/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author drew
 */
public class User {
    
    private String uname, pass;
    private Map<Textbook, List<RatingValue> > ratings;

    public User(String uname, String pass, Map<Textbook, List<RatingValue>> ratings) {
        this.uname = uname;
        this.pass = pass;
        this.ratings = ratings;
    }
    public User() {
        ratings = new TreeMap<Textbook, List<RatingValue>>();
    }

    public void clear() {
        uname = "";
        pass = "";
        ratings.clear();
    }
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Map<Textbook, List<RatingValue>> getRatings() {
        return ratings;
    }

    public void setRatings(Map<Textbook, List<RatingValue>> ratings) {
        this.ratings = ratings;
    }
    
    
}
