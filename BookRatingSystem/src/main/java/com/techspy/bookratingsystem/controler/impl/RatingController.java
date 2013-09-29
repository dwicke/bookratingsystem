/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.techspy.bookratingsystem.controler.IRatingController;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Textbook;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is used to update the ratings of textbooks.
 * It publishes the ratings so appropriate views can be updated.
 * @author drew
 */
public class RatingController implements IRatingController {

    private Map<Textbook, List<RatingValue>> ratings;
    
    public RatingController() {
        ratings = new TreeMap<Textbook, List<RatingValue>>();
    }
    
    
    
    public List<RatingValue> getRating(Textbook book) {
        return ratings.get(book);
    }

    public void init() {
        
    }
    
}
