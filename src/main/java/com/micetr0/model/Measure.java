/*
 *     Server-Side Measure model class
 *     Measure.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

import com.micetr0.model.Section;
import com.micetr0.definitions.Defs;

public class Measure {

    public Measure() {
        //empty constructor
    }

    private Integer maxNumBeats;
    private String measureID;
    private String sectionID;


    public Integer getMaxNumBeats(){
        return maxNumBeats;
    }

    public void setMaxNumBeats(Integer maxNumBeats){
        this.maxNumBeats = maxNumBeats;
    }

    public String getMeasureID(){
        return measureID;
    }

    public void setMeasureID(String measureID){
        this.measureID = measureID;
    }

    public String getSectionID(){
        return sectionID;
    }

    public void setSectionID(String sectionID){
        this.sectionID = sectionID;
    }
}