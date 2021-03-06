/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IRatingController;
import com.techspy.bookratingsystem.controler.ITextbookController;
import com.techspy.bookratingsystem.model.RatingEnum;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Textbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is used to update the ratings of all textbooks.
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

    
    @Inject public void init(ITextbookController txtbookController) {
        // get all textbooks and create ratings...
        for(Textbook book : txtbookController.getTextbooks("")) {
            List<RatingValue> vals = new ArrayList<RatingValue>();
            vals.add(new RatingValue(3, 5, 5, RatingEnum.HELPFUL));
            vals.add(new RatingValue(3, 5, 5, RatingEnum.CLARITY));
            vals.add(new RatingValue(3, 5, 5, RatingEnum.EASINESS));
            vals.add(new RatingValue(3, 5, 5, RatingEnum.OVERALL));
            ratings.put(book, vals);
        }
    }

    public void addRating(Textbook text, List<RatingValue> rating) {
         List<RatingValue> prevRatings = ratings.get(text);
        for (RatingValue val : rating) {
            RatingValue oldVal = prevRatings.get(prevRatings.indexOf(val));
            oldVal.addPossible(val.getPossible());
            oldVal.addTotal(val.getTotal());
        }
        updateOverall(text);
    }

    public void removeRating(Textbook text, List<RatingValue> rating) {
        
        List<RatingValue> prevRatings = ratings.get(text);
        for (RatingValue val : rating) {
            RatingValue oldVal = prevRatings.get(prevRatings.indexOf(val));
            oldVal.addPossible(-1 * val.getPossible());
            oldVal.addTotal(-1 * val.getTotal());
        }
        
        updateOverall(text);
    }

    public void updateOverall(Textbook book) {
        RatingValue over = new RatingValue(0, 0, 0, RatingEnum.OVERALL);
        RatingValue overall = ratings.get(book).get(ratings.get(book).indexOf(over));
        for (RatingValue val : ratings.get(book)) {
            if (!val.equals(over)) {
                overall.setPossible(val.getPossible());
                overall.setTotal(val.getTotal());
            }
        }
    }
    
    
}
