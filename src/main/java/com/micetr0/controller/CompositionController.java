/*
 *     Server-Side Composition Controller class
 *     CompositionController.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.model.Composition;

import java.time.LocalDate;

public class CompositionController {

    private IDatabase db;
    private LocalDate date;

    public CompositionController(){
        date = LocalDate.now();
        db = DatabaseProvider.getInstance();
    }



//    public Boolean updateTitle(Composition composition, String title) {
//        Boolean isCompUpdated = false;
//
//
//        return isCompUpdated;
//    }

    /**
     * Attempts to update the year attribute of the given composition in the database. If this is successful,
     * the year of the composition object is updated, and updateYear returns true.
     * @param composition A composition object.
     * @param year The year that this composition was written
     * @return Boolean isCompUpdated: True when update is successful, false when composition is not found
     */
    public Boolean updateYear(Composition composition, Integer year) {
        Boolean isCompUpdated = false;
        System.out.println("Current year is: " + date.getYear());

        // check to see that the date is not set in the future
        if (year <= date.getYear()) {
            // insert year into the database and check to see if insertion was successful
            if(db.updateCompositionYearByCompositionId(composition.getCompositionID(), year)) {
                composition.setYear(year);
                isCompUpdated = true;
            }
        }

        return isCompUpdated;
    }


    /**
     * Attempts to update the description attribute of the given composition in the database. If this is successful,
     * the description of the composition object is updated, and updateDescription returns true.
     * @param composition A composition object.
     * @param description A String which describes the composition. This will be editable by the user and
     *                    displayed on the composition or profile page (optional)
     * @return Boolean isCompUpdated: True when update is successful, false when composition is not found
     */
    public Boolean updateDescription(Composition composition, String description) {
        Boolean isCompUpdated = false;

        if (db.updateCompositionDescriptionByCompositionId(composition.getCompositionID(), description)) {
            composition.setDesc(description);
            isCompUpdated = true;
        }

        return isCompUpdated;
    }

//    public Composition createComposition(String title, Integer year, String desc, Integer compID)
//    {
//        Composition newComp = new Composition();
//        newComp.setYear(year);
//        newComp.setTitle(title);
//        newComp.setCompositionID(compID);
//        newComp.setDesc(desc);
//
//        return newComp;
//    }


}
