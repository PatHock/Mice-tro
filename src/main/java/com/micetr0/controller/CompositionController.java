/*
 *     Server-Side Composition Controller class
 *     CompositionController.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.controller;

import com.micetr0.model.Composition;
import com.micetr0.model.Section;

import java.util.List;

public class CompositionController {

    Composition composition = new Composition();

    public void setModel(Composition composition) {
        this.composition = composition;
    }

    public void changeTitle(String newTitle)
    {
        if(!newTitle.equals(composition.getTitle())) {
            composition.setTitle(newTitle);
        }

        else{
            // title shouldn't change
        }
    }

    public void changeYear(Integer year)
    {
        if(!year.equals(composition.getYear())) {
            composition.setYear(year);
        }

        else{
            // title shouldn't change
        }
    }

    public Composition createComposition(String title, Integer year, Integer authorID)
    {
        Composition newComp = new Composition();
        newComp.setYear(year);
        newComp.setAuthor(authorID);

        return newComp;
    }


}
