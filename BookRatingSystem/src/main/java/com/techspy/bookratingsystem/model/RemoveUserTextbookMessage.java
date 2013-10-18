/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

/**
 *
 * @author drew
 */
public class RemoveUserTextbookMessage {
    
    Textbook book;
    public RemoveUserTextbookMessage(Textbook book) {
        this.book = book;
    }
    public Textbook getBook() {
        return book;
    }
}
