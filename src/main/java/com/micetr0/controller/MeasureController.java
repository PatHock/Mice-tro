/*
 *     Server-Side Measure Controller class
 *     MeasureController.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.controller;
import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.InitDatabase;
import com.micetr0.model.Measure;

import java.util.ArrayList;
import java.util.List;

public class MeasureController {

    private Measure measure = new Measure();
    private IDatabase db;
    private List<Measure> dbMeasures = new ArrayList<>();

    public MeasureController()
    {
        InitDatabase.init(true);
        db = DatabaseProvider.getInstance();
    }

    public void setModel(Measure measure) {
        this.measure = measure;
    }

    public Measure createMeasure(Integer maxNumBeats,String measureID,String sectionID){
        Measure newMeas = new Measure();
        newMeas.setMaxNumBeats(maxNumBeats);
        newMeas.setMeasureID(measureID);
        newMeas.setSectionID(sectionID);
        return newMeas;
    }

    public boolean deleteMeasure(){
        return false;
    }

    public void addMeasure(Measure measure){
        //add code to add measure to database
    }
    // test commit

}