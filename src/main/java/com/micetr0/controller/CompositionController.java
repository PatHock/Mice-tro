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
import java.time.LocalDateTime;

public class CompositionController {

    private IDatabase db;
    private LocalDateTime date;
    private String descriptionDefault;
    private String titlePrefixDefault;

    public CompositionController(){
        date = LocalDateTime.now();

        db = DatabaseProvider.getInstance();
        descriptionDefault = "Add your creative description here!";
        titlePrefixDefault = "Untitled";
    }


    public Composition createComposition(){
        String title;
        date = LocalDateTime.now();

        // Title is unique based on current date and time
        title =  titlePrefixDefault + "_" +date.toLocalDate() + "-" + date.toLocalTime();
        System.out.println(title);

        return db.createComposition(title, descriptionDefault, date.getYear());
    }

    /**
     * Attempts to update the title attribute of the given composition in the database. If this is successful,
     * the title of the composition object is updated, and updateTitle returns true.
     * @param composition   A composition object.
     * @param title         The title of the composition, specified by the user
     * @return Boolean isCompUpdated: True when update is successful, false when composition is not found
     * or when the title is invalid
     */
    public Boolean updateTitle(Composition composition, String title) {
        Boolean isCompUpdated = false;

        if (db.updateCompositionTitleByCompositionId(composition.getCompositionID(), title)) {
            isCompUpdated = true;
        }

        return isCompUpdated;
    }



    /**
     * Attempts to update the year attribute of the given composition in the database. If this is successful,
     * the year of the composition object is updated, and updateYear returns true.
     * @param composition   A composition object.
     * @param year          The year that this composition was written
     * @return Boolean isCompUpdated: True when update is successful, false when composition is not found
     * or when the year is invalid
     */
    public Boolean updateYear(Composition composition, Integer year) {
        Boolean isCompUpdated = false;
        System.out.println("Current year is: " + date.getYear());

        // check to see that the date is not set in the future
        if (isValidYear(year)) {
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

    /**
     * Private helper function to check if year is not in the future
     * @param year The year the composition was written
     * @return True if year is valid, false otherwise
     */
    private Boolean isValidYear(Integer year) {
        Boolean isValidYear = false;
        if (year <= date.getYear()) {
            isValidYear = true;
        }
        return isValidYear;
    }


}
