/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler;

import com.techspy.bookratingsystem.model.Textbook;
import java.util.List;

/**
 *
 * @author drew
 */
public interface ITextbookController {
    
    /**
     * Add a textbook to the system.
     * @param book Book to be added.
     */
    public void addTextbook(Textbook book);
    
    /**
     * Gets the list of textbooks that contain the titleKeyword in their title
     * @param titleKeyword the string to look for in the title
     * @return the list of books that have such a keyword in their title.
     */
    public List<Textbook> getTextbooks(String titleKeyword);
    /**
     * Fill in the known info and this will give you the rest filled in
     * if it knows about it.
     * @param book the book to be found
     * @return the corresponding book
     */
    public Textbook getTextbook(Textbook book);
    
}
