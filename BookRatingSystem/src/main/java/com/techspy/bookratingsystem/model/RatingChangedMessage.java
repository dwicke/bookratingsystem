/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

/**
 *
 * @author drew
 */
public class RatingChangedMessage {
    private Textbook book;
    private RatingValue val;
    public RatingChangedMessage(Textbook book, RatingValue val) {
        this.book = book;
        this.val = val;
    }
    
    public Textbook getBook() {
        return book;
    }

    public RatingValue getVal() {
        return val;
    }
}
