/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.techspy.bookratingsystem.controler.ITextbookController;
import com.techspy.bookratingsystem.model.Textbook;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author drew
 */
public class TextbookController implements ITextbookController{

    List<Textbook> books;
    public TextbookController() {
        books = new ArrayList<Textbook>();
        for (int i = 0; i < 10; i++) {
            Textbook book = new Textbook();
            book.setAuthor("Me" + i);
            book.setTitle("You" + i);
            book.setId(i + "");
            addTextbook(book);
        }
        for (int i = 10; i < 20; i++) {
            Textbook book = new Textbook();
            book.setAuthor("Me" + i);
            book.setTitle("Yoyo" + i);
            book.setId(i + "");
            addTextbook(book);
        }
    }
    
    
    public void addTextbook(Textbook book) {
        books.add(book);
    }

    public List<Textbook> getTextbooks(String titleKeyword) {
        List<Textbook> results = new ArrayList<Textbook>();
        for (Textbook book : books) {
            if (book.getTitle().contains(titleKeyword))
                results.add(book);
        }
        return results;
    }

    public Textbook getTextbook(Textbook bookQuery) {
        for (Textbook book : books) {
            if ( book.getId().equals(bookQuery.getId()) || 
                    book.getAuthor().equals(bookQuery.getAuthor()) ||
                    book.getTitle().equals(bookQuery.getTitle()))
                return book;
        }
        return bookQuery;
    }
    
}
