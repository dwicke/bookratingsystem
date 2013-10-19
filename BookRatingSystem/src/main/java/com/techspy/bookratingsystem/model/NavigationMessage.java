/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

/**
 *
 * @author drew
 */
public class NavigationMessage {
    boolean nextPage;
    public NavigationMessage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isNextPage() {
        return nextPage;
    }
    
}
