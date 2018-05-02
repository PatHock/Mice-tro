package com.micetr0;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Account;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import com.micetr0.model.Composition;
import com.micetr0.model.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

public class AbcTranslatorTest {

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void getCompTitleTest(){
        Composition comp = new Composition();
        AbcTranslator translator = new AbcTranslator();
        comp.setTitle("NewComp");

        assertTrue(comp.getTitle().equals(translator.getCompTitle(comp)));
    }

    @Test
    public void getTimeSigTest(){
        Section sec = new Section();
        sec.setTimeSig(Defs.TimeSignature.FOUR_FOUR);
    }
}
