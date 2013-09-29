/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

/**
 *
 * @author drew
 */
public class RatingValue {
    private float rating;
    private String ratingCategory;
    
    public RatingValue(float rating, String category) {
        this.rating = rating;
        this.ratingCategory = category;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getRatingCategory() {
        return ratingCategory;
    }

    public void setRatingCategory(String ratingCategory) {
        this.ratingCategory = ratingCategory;
    }
    

    @Override
    public String toString() {
        return ratingCategory + ": " + rating + " /5.0";
    }
    
}
