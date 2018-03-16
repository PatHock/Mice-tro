package com.micetr0.controller;

import com.micetr0.model.Composition;
import com.micetr0.model.Section;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompositionControllerTest {

    private Composition model;
    private CompositionController controller;

    @Before
    public void setUp(){
        model = new Composition();
        controller = new CompositionController();
        controller.setModel(model);
    }

    @Test
    public void deleteSectionTest()
    {
        List<Section> sections = new ArrayList<Section>();
        Section section1 = new Section();
        Section section2 = new Section();
        sections.add(section1);
        sections.add(section2);
        model.setSections(sections);
        sections = model.getSections();

        boolean deleted = controller.deleteSection(0);
        assertTrue(deleted == true);
        assertTrue(sections.get(0).equals(section2));
    }

    @Test
    public void addSectionTest()
    {
        controller.addSection();
        assertTrue(model.getSections().size()==1);
        controller.addSection();
        assertTrue(model.getSections().size()==2);

    }

    @Test
    public void changeTitleTest()
    {
        String title = "My first composition";
        controller.changeTitle(title);
        assertTrue(model.getTitle().equals(title));
        controller.changeTitle(title);
        assertTrue(model.getTitle().equals(title));
        title = "Title";
        controller.changeTitle(title);
        assertTrue(model.getTitle().equals(title));
    }

}