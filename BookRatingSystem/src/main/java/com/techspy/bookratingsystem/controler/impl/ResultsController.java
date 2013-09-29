/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IResultsController;
import com.techspy.bookratingsystem.model.Result;
import com.techspy.bookratingsystem.model.ResultsModel;
import java.util.ArrayList;

/**
 *
 * @author drew
 */
public class ResultsController implements IResultsController{
    
    private ResultsModel resModel;
    private EventBus bus;
    
    @Inject public ResultsController(EventBus bus) {
        this.bus = bus;
        resModel = new ResultsModel();
    }

    public void addResult(Result res) {
        resModel.addResult(res);
    }

    public void clearResults() {
        resModel.setResults(new ArrayList<Result>());
    }
    
    
    
    
}
