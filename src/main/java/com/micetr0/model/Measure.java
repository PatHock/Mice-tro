/*
 *     Server-Side Measure model class
 *     Measure.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;


public class Measure {

    private Integer measureID;
    private Integer sectionID;

    /**
     * Measure constructor.
     * @param measureID unique ID of this measure
     * @param sectionID Section ID of the section this measure belongs to
     */
    public Measure(Integer measureID, Integer sectionID) {
        this.measureID = measureID;
        this.sectionID = sectionID;
    }

    /**
     * Standard model getter
     * @return unique measure ID
     */
    public Integer getMeasureID(){
        return this.measureID;
    }

    /**
     * TODO Most likely will be deleted in the future
     * @param measureID unique ID for measure in db
     */
    public void setMeasureID(Integer measureID) {
        this.measureID = measureID;
    }
    /**
     * Standard model getter
     * @return section ID for this measure
     */
    public Integer getSectionID(){
        return this.sectionID;
    }

    /**
     * Just your average model set function. Ties measure to a section.
     * @param sectionID unique section ID to associate measure with section
     */
    public void setSectionID(Integer sectionID){
        this.sectionID = sectionID;
    }


}