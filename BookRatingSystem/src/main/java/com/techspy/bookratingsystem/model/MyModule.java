/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

import com.techspy.bookratingsystem.controler.impl.SearchController;
import com.techspy.bookratingsystem.controler.ISearchController;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.techspy.bookratingsystem.controler.IRatingController;
import com.techspy.bookratingsystem.controler.IResultsController;
import com.techspy.bookratingsystem.controler.ITextbookController;
import com.techspy.bookratingsystem.controler.IUserController;
import com.techspy.bookratingsystem.controler.impl.RatingController;
import com.techspy.bookratingsystem.controler.impl.ResultsController;
import com.techspy.bookratingsystem.controler.impl.TextbookController;
import com.techspy.bookratingsystem.controler.impl.UserController;

/**
 *
 * @author drew
 */
public class MyModule extends AbstractModule{
    
    // make the eventbus be asynchronous need it to be fast...
    private final EventBus eventBus = new EventBus("Default EventBus");
    @Override
    protected void configure() {
        bind(EventBus.class).toInstance(eventBus);
        bind(ISearchController.class).to(SearchController.class).asEagerSingleton();
        bind(ITextbookController.class).to(TextbookController.class).asEagerSingleton();
        bind(IUserController.class).to(UserController.class).asEagerSingleton();
        bind(IRatingController.class).to(RatingController.class).asEagerSingleton();
        bind(IResultsController.class).to(ResultsController.class).asEagerSingleton();
        
        // bind the other controllers as singletons
    }
    
}
