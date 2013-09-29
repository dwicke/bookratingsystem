/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techspy.bookratingsystem.model;

import com.techspy.bookratingsystem.view.StarRater;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * This models the results.  I am not going to dictate
 * that their be specific number of columns.
 * @author drew
 */
public class ResultsModel {

    //public String [] columns = { "Title", "Author", "Helpfulness", "Clarity", "Easiness",  "Overall"};
    
    private List<Result> results;
    
    public ResultsModel() {
        results = new ArrayList<Result>();
    }
    public void setResults(List<Result> res) {
        this.results = res;
    }
    public void addResult(Result res) {
        results.add(res);
    }
    
    public int getRowCount() {
        return results.size();
    }

    
    public Result getResult(int i) {
        return results.get(i);
    }
    
    
    
}
