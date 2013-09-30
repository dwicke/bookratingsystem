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
    private int total, possible, outof;
    
    /**
     * 
     * @param total the total number of stars that have been given in this rating
     * @param possible the total possible number of starts that could have been given
     * @param outof the number of stars per person
     * @param category the category that this rating belongs to
     */
    public RatingValue(int total, int possible, int outof, String category) {
        this.total = total;
        this.possible = possible;
        this.outof = outof;
                
        
        this.rating = (float)total / (float) possible * (float) outof;
        this.ratingCategory = category;
    }

    public float getRating() {
        return (float)total / (float) possible * (float) outof;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPossible() {
        return possible;
    }

    public void setPossible(int possible) {
        this.possible = possible;
    }
    

    @Override
    public String toString() {
        return ratingCategory + ": " + rating + " /5.0";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RatingValue))
            return false;
        return ((RatingValue) obj).ratingCategory.equals(ratingCategory);
    }

    public void update(RatingValue rating) {
        outof = rating.outof;
        possible = rating.possible;
        total = rating.total;
    }
    
    
    
}
