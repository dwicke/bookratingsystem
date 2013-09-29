/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

import com.techspy.bookratingsystem.controler.impl.SearchController;
import com.techspy.bookratingsystem.controler.ISearchController;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.techspy.bookratingsystem.controler.IUserController;
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
        bind(IUserController.class).to(UserController.class).asEagerSingleton();
        
        // bind the other controllers as singletons
    }
    
}
