/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler.impl;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.techspy.bookratingsystem.controler.IResultsController;
import com.techspy.bookratingsystem.model.NavigationMessage;
import com.techspy.bookratingsystem.model.Result;
import com.techspy.bookratingsystem.model.ResultsModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drew
 */
public class ResultsController implements IResultsController{
    
    private ResultsModel resModel;
    private EventBus bus;
    private int pageSize = 4;
    private int curPage = 0;
    
    @Inject public ResultsController(EventBus bus) {
        this.bus = bus;
        resModel = new ResultsModel();
    }

    public void addResult(Result res) {
        resModel.addResult(res);
    }

    public void clearResults() {
        resModel.setResults(new ArrayList<Result>());
        curPage = 0;
    }
    
    
    public Result getResult(int i) {
        return resModel.getResult(i);
    }

    public List<Result> getNextResultPage() {
        List<Result> page = new ArrayList<Result>();
        if (!hasNextPage()) {
            curPage--;
        }
        for (int i = pageSize * curPage; i < pageSize * (curPage + 1); i++) {
            if (i < resModel.getRowCount())
                page.add(resModel.getResult(i));
            else
                break;
        }
        
        curPage++;
        return page;
    }

    public List<Result> getPrevResultPage() {
        if (hasPrevPage()) {
            curPage--;
            curPage--;
            return getNextResultPage();
        }
        curPage--;
        return getNextResultPage();// show the current page.
    }
    
    
    public void setPageSize(int size) {
        pageSize = size;
    }

    public int getNumPages() {
        return (getNumResults() + pageSize - 1) / pageSize;// round up
    }
    
    public int getNumResults() {
        return resModel.getRowCount();
    }
    
    public boolean hasNextPage() {
        return pageSize * curPage < getNumResults();
    }

    public boolean hasPrevPage() {
        return (curPage - 1) > 0;
    }
    
    public int getCurrentPage() {
        return curPage;
    }
    
}
