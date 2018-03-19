/*
 * Server-Side Section Controller class
 * SectionController.java
 * Created Mar 06, 2018 by Patrick Hock
 * Insert Description Here
 */

package com.micetr0.controller;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Section;

public class SectionController {

    /**
     * @param: TimeSignature enum type TimeSignature
     * @param: Key enum type Key
     * @param: Clef enum type clef
     * @return:
     */
    public Section createSection(Integer tempo, Defs.Key key, Defs.Clef clef, Defs.TimeSignature timeSig, String compID, String secID){
        Section newSection = new Section();
        newSection.setClef(clef);
        newSection.setKey(key);
        newSection.setOwningComp(compID);
        newSection.setTempo(tempo);
        newSection.setSectionID(secID);
        return newSection;
    }

    public void deleteSection()
    {}
}
