/*
 *     Server-Side Measure Controller class
 *     MeasureController.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.controller;
import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.model.Measure;

import java.util.ArrayList;
import java.util.List;


public class MeasureController {
    //FIXME This class

    private IDatabase db;

    public MeasureController()
    {
        db = DatabaseProvider.getInstance();
    }

    /**
     *
     * @param sectionID unique section ID
     */
    public Measure createMeasure(Integer sectionID){
        Measure measure = new Measure();
        measure.setSectionID(sectionID);
        return measure;
    }

    public Boolean insertMeasure(Integer sectionID){
        if(db.insertMeasure(sectionID)){
            return true;
        }
        return false;
    }
    /**
     *
     * @param measureID unique ID for measures. Generated by db methods
     */
    public Boolean deleteMeasure(Integer measureID){
        if(db.deleteMeasure(measureID))
        {
            return true;
        }
        return false;
    }


}