/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler;

import com.google.common.eventbus.Subscribe;
import com.techspy.bookratingsystem.model.SearchTerm;

/**
 * Used to search for textbooks.
 * @author drew
 */
public interface ISearchController {
    public void search();
    public ISearchController setTitle(String title);
}
