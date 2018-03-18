package com.micetr0.controller;

import com.micetr0.model.Measure;
import com.micetr0.model.Note;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MeasureControllerTest {
    private MeasureController controller;
    private Measure model;

    @Before
    public void setUp()
    {
        controller = new MeasureController();
    }


}
