/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IRatingController;
import com.techspy.bookratingsystem.controler.IResultsController;
import com.techspy.bookratingsystem.controler.ISearchController;
import com.techspy.bookratingsystem.controler.ITextbookController;
import com.techspy.bookratingsystem.model.Result;
import com.techspy.bookratingsystem.model.SearchTerm;
import com.techspy.bookratingsystem.model.Textbook;

/**
 * Used to search for textbooks based on a SearchTerm
 * @author drew
 */
public class SearchController implements ISearchController {
    
    private EventBus bus;
    private SearchTerm searchValue;
    private IResultsController resultsController;
    private ITextbookController textbookController;
    private IRatingController ratingController;
    @Inject
    public SearchController(EventBus bus/*, IResultsController searchResultsControl, ITextbookController tc, IRatingController rc*/) {
        this.bus = bus;
        this.searchValue = new SearchTerm();
        //resultsController = searchResultsControl;
        //textbookController = tc;
        //ratingController = rc;
        
    }
    
    @Inject public void init(IResultsController searchResultsControl, ITextbookController tc, IRatingController rc) {
        resultsController = searchResultsControl;
        textbookController = tc;
        ratingController = rc;
    }

    @Override
    public void search() {
        // add results via IResultsController
        // then post results
        for(Textbook book : textbookController.getTextbooks(searchValue.getSearchTerm())){
            resultsController.addResult(new Result(book, ratingController.getRating(book)));
        }
        bus.post(resultsController);
    }

    
    
    public ISearchController setTitle(String title) {
        searchValue.setSearchTerm(title);
        return this;
    }
    
}
