/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author drew
 */
public class Result {
    private Textbook book;
    private List<RatingValue> ratings;
    
    
    public Result(){
        book = new Textbook();
        ratings = new ArrayList<RatingValue>();
    }
    
    public Result(Textbook book, List<RatingValue> ratings) {
        this.book = book;
        this.ratings = ratings;
    }

    public Textbook getBook() {
        return book;
    }

    public void setBook(Textbook book) {
        this.book = book;
    }

    public List<RatingValue> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingValue> ratings) {
        this.ratings = ratings;
    }
    
            
}
