/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.techspy.bookratingsystem.controler.IRatingController;
import com.techspy.bookratingsystem.controler.ITextbookController;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Textbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is used to update the ratings of textbooks.
 * It publishes the ratings so appropriate views can be updated.
 * @author drew
 */
@Singleton
public class RatingController implements IRatingController {

    private Map<Textbook, List<RatingValue>> ratings;
    
    public RatingController() {
        ratings = new TreeMap<Textbook, List<RatingValue>>();
    }
    
    
    
    public List<RatingValue> getRating(Textbook book) {
        return ratings.get(book);
    }

    
    public void init(ITextbookController txtbookController) {
        // get all textbooks and create ratings...
        for(Textbook book : txtbookController.getTextbooks("")) {
            List<RatingValue> vals = new ArrayList<RatingValue>();
            vals.add(new RatingValue(3, 5, 5, "Helpfulness"));
            vals.add(new RatingValue(3, 5, 5, "Clarity"));
            vals.add(new RatingValue(3, 5, 5, "Easiness"));
            vals.add(new RatingValue(3, 5, 5, "Overall"));
            ratings.put(book, vals);
        }
    }

    
}
