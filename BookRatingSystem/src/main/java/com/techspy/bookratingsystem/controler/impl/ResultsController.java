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
import java.util.List;

/**
 *
 * @author drew
 */
public class ResultsController implements IResultsController{
    
    private ResultsModel resModel;
    private EventBus bus;
    private int pageSize = 5;
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
        List<Result> page = new ArrayList<Result>();
        
        for (int i = pageSize * curPage; i > pageSize * (curPage - 1); i--) {
            if (i < resModel.getRowCount())
                page.add(resModel.getResult(i));
            else
                break;
        }
        
        curPage--;
        return page;
    }

    public void setPageSize(int size) {
        pageSize = size;
    }

    public boolean hasNextPage() {
        return true;
    }

    public boolean hasPrevPage() {
        return true;
    }
    
}
