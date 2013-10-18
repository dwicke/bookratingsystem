/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

/**
 *
 * @author drew
 */
public class Textbook implements Comparable<Textbook> {
    private String title, author, id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int compareTo(Textbook o) {
        return o.id.compareTo(id);
    }

    @Override
    public boolean equals(Object obj) {
        //To change body of generated methods, choose Tools | Templates.
        if (!(obj instanceof Textbook)){
            return false;
        }
        return ((Textbook) obj).id.equals(id);
    }
    
    
}
