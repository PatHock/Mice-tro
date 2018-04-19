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
    public void createSection(Integer tempo, Defs.Key key, Defs.Clef clef, Defs.TimeSignature timeSig, String compID, Integer secID){
        Section newSection = new Section();
        newSection.setClef(clef);
        newSection.setKey(key);
        newSection.setOwningComp(compID);
        newSection.setTempo(tempo);
        newSection.setSectionID(secID);
    }

    public void deleteSection()
    {}
}
