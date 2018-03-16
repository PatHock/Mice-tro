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

    public boolean deleteSection(int index)
    {
      List<Section> sections = composition.getSections();

      if(sections.size() < 1 || (sections.size() < index+1))
      {
          // don't do anything, theres nothing to remove
          return false;
      }
      else{
          sections.remove(index);
          composition.setSections(sections);
          return true;
      }
    }
    public boolean addSection()
    {
        List<Section> sections = composition.getSections();
        Section section = new Section();
        sections.add(section);
        composition.setSections(sections);
        return true;
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
}
