/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.techspy.bookratingsystem.model.RatingValue;
import com.techspy.bookratingsystem.model.Result;
import com.techspy.bookratingsystem.model.Textbook;
import java.util.List;
import java.util.Map;

/**
 * Used to update the ratings of textbooks
 * @author drew
 */

public interface IRatingController {
    //public void addRating(Result res);
    /**
     * get ratings associated with the textbook
     * @param book
     * @return 
     */
    public List<RatingValue> getRating(Textbook book);
    
    
    
    /**
     * initialize the rating controller.  should be first method called.
     */
    public void init(ITextbookController txtbookController);
    
    public void addRating(Textbook text, List<RatingValue> rating);
    public void removeRating(Textbook text, List<RatingValue> rating);
    
}
