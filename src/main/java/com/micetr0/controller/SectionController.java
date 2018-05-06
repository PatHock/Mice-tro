/*
 * Server-Side Section Controller class
 * SectionController.java
 * Created Mar 06, 2018 by Patrick Hock
 * Insert Description Here
 */

package com.micetr0.controller;

import com.micetr0.definitions.Defs;
import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.model.Section;

import java.util.List;
//import org.springframework.stereotype.Controller;

//@Controller
public class SectionController {

    private IDatabase db;

    public SectionController(){
        db = DatabaseProvider.getInstance();
    }
    /**
     * @param: TimeSignature enum type TimeSignature
     * @param: Key enum type Key
     * @param: Clef enum type clef
     * @return:
     */
    public Section createSection(Integer tempo, Defs.Key key, Defs.Clef clef, Defs.TimeSignature timeSig, Integer compID, Integer secID){
        Section newSection = new Section();
        newSection.setClef(clef);
        newSection.setKey(key);
        newSection.setCompID(compID);
        newSection.setTempo(tempo);
        newSection.setTimeSig(timeSig);
        newSection.setSectionID(secID);
        if(addDBSection(newSection) > 0) {
            return newSection;
        }
        return null;
    }

    private Integer addDBSection(Section section)
    {
        Integer sectionId = db.insertSection(section.getKey(), section.getTimeSig(),section.getClef(), section.getTempo(),section.getCompID());
        return sectionId;
    }

    public Boolean deleteSection(Integer sectionID)
    {
        db.deleteSection(sectionID);
        return true;
    }
    public List<Section> findSection(Integer sectionID)
    {
        return db.findSectionFromSectionID(sectionID);

    }

    public List<Section> findAllSections(){
        return db.findAllSections();
    }

    //Will not implement updateSection functions for time being.

}
