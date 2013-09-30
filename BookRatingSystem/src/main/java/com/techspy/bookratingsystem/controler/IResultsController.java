/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler;

import com.techspy.bookratingsystem.model.Result;
import java.util.List;

/**
 * 
 * @author drew
 */
public interface IResultsController {
    public void addResult(Result res);
    public void clearResults();
    public void setPageSize(int size);
    public List<Result> getNextResultPage();
    public List<Result> getPrevResultPage();
    public boolean hasNextPage();
    public boolean hasPrevPage();
   
}
