/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.controler;

import com.techspy.bookratingsystem.model.Result;

/**
 * 
 * @author drew
 */
public interface IResultsController {
    public void addResult(Result res);
    public void clearResults();
}
