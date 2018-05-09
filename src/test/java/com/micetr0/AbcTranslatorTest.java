package com.micetr0;

import com.micetr0.controller.CompositionController;
import com.micetr0.controller.MeasureController;
import com.micetr0.controller.NoteController;
import com.micetr0.controller.SectionController;
import com.micetr0.definitions.Defs;
import com.micetr0.mock_DB.*;
import com.micetr0.model.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.dao.DataIntegrityViolationException;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbcTranslatorTest {

    private AbcTranslator translator;
    private CompositionController compositionController;
    private SectionController sectionController;
    private MeasureController measureController;
    private NoteController noteController;
    private IDatabase db;



    @BeforeEach
    void setUp(){
        DatabaseProvider.setInstance(new MySqlDB());
        db = DatabaseProvider.getInstance();
        translator = new AbcTranslator();
        compositionController = new CompositionController();
        sectionController = new SectionController();
        measureController = new MeasureController();
        noteController = new NoteController();
    }

    @Test
    public void getCompTitleTest(){
        Composition comp = new Composition();

        comp.setTitle("NewComp");

        assertTrue(comp.getTitle().equals(translator.getCompTitle(comp)));
    }

    @Test
    public void getTimeSigTest(){
        Section sec = new Section();
        sec.setTimeSig(Defs.TimeSignature.FOUR_FOUR);

        assertTrue(translator.getTimeSig(sec).equals("4/4"));
    }

    @Test
    public void getNoteTest(){
        Note note = new Note(0, Defs.NoteType.QUARTER, Defs.Pitch.A0_SHARP,0,0);

        String stNote = translator.getNote(note);
        assertTrue(stNote.equals("^A0"));

        note.setPitch(Defs.Pitch.A0_FLAT);
        stNote = translator.getNote(note);
        assertTrue(stNote.equals("_A0"));

        note.setPitch(Defs.Pitch.A0);
        stNote = translator.getNote(note);
        assertTrue(stNote.equals("A0"));
    }

    @Test
    public void getKeyTest(){
        Section section = new Section();
        section.setKey(Defs.Key.C_MAJOR);
        String modified = translator.getKey(section);
        assertTrue(modified.equals("C"));
        section.setKey(Defs.Key.D_MAJOR);
        modified = translator.getKey(section);
        assertTrue(modified.equals("D"));
        section.setKey(Defs.Key.G_MAJOR);
        modified = translator.getKey(section);
        assertTrue(modified.equals("G"));
    }

    @Test
    public void abcBuilderTest(){
//        Section section = new Section();
        String title = "One Super sick title!!!";
        Composition composition = compositionController.createComposition(2);

        Section section = sectionController.createSection(128, Defs.Key.C_MAJOR, Defs.Clef.TREBLE, Defs.TimeSignature.FOUR_FOUR, composition.getCompositionID());
        Measure measure = measureController.createMeasure(section.getSectionID());
        noteController.addNote(Defs.NoteType.HALF, Defs.Pitch.A0, Defs.Key.C_MAJOR, 1, measure.getMeasureID());
        noteController.addNote(Defs.NoteType.HALF, Defs.Pitch.A1, Defs.Key.C_MAJOR, 2, measure.getMeasureID());
        Measure measure2 = measureController.createMeasure(section.getSectionID());
        noteController.addNote(Defs.NoteType.HALF, Defs.Pitch.A2, Defs.Key.C_MAJOR, 1, measure2.getMeasureID());
        noteController.addNote(Defs.NoteType.EIGHTH, Defs.Pitch.A3, Defs.Key.C_MAJOR, 2, measure2.getMeasureID() );

        assertTrue(compositionController.updateTitle(composition, title));
        //assertEquals(3, db.findNotesByMeasureId(measure.getMeasureID()).size());
        //assertEquals(3,db.findNotesByMeasureId(measure2.getMeasureID()).size());

        String out = translator.abcBuilder(composition);

        assertEquals(out,"X: 1\n"
                + "T: " + translator.getCompTitle(composition) + "\n"
                + "M: " + translator.getTimeSig(section) + "\n"
                + "L: 1/8 \n"
                + "R: reel \n"
                + "K: " + translator.getKey(section) + "\n"
                + " |"
                + "^A6 "
                + "A0"
                + " A1"
                + "|"
                + "B4 "
                + "A2 "
                + "A3"
                + "|"
        );
    }

    @Test
    public void parseABCTest(){
        String abcPattern = "X: 1\n"
                + "T: " + "Woahhhhh" + "\n"
                + "M: " + "4/4" + "\n"
                + "L: " + "1/8" +"\n"
                + "R: reel" +"\n"
                + "K: " + "Gm" + "\n"
                + "DA BE|F E B A|";
        List<String> abcComps = translator.parseABC(abcPattern);

        assertTrue(abcComps.get(1).equals("T: Woahhhhh"));
        assertTrue(abcComps.get(2).equals("M: 4/4"));
        assertTrue(abcComps.get(3).equals("L: 1/8"));
        assertTrue(abcComps.get(4).equals("R: reel"));
        assertTrue(abcComps.get(5).equals("K: Gm"));
        assertTrue(abcComps.get(6).equals("DA BE|F E B A|"));
    }

    @Test
    public void extractNoteMeasuresTest(){
        String abcPattern = "X: 1\n"
                + "T: " + "Woahhhhh" + "\n"
                + "M: " + "4/4" + "\n"
                + "L: " + "1/8" +"\n"
                + "R: reel" +"\n"
                + "K: " + "Gm" + "\n"
                + "DA BE|F E B A|";
        List<String> measures = translator.extractNoteMeasures(abcPattern);

        assertEquals(measures.get(0),"DA BE");
        assertEquals(measures.get(1),"F E B A");
    }

    @Test
    public void extractNoteStringsTest(){
        String abcPattern = "X: 1\n"
                + "T: " + "Woahhhhh" + "\n"
                + "M: " + "4/4" + "\n"
                + "L: " + "1/8" +"\n"
                + "R: reel" +"\n"
                + "K: " + "Gm" + "\n"
                + "_D0A0 B0C0|*F0 E0G0A0|";

        List<String> notes = translator.extractNoteStrings(translator.extractNoteMeasures(abcPattern));

        assertEquals(notes.get(0),"_D0");
        assertEquals(notes.get(1),"A0");
        assertEquals(notes.get(2),"B0");
        assertEquals(notes.get(3),"C0");
        assertEquals(notes.get(4),"*F0");
        assertEquals(notes.get(5),"E0");
        assertEquals(notes.get(6),"G0");
        assertEquals(notes.get(7),"A0");
    }

    @Test
    public void createNotePitchTest(){
        assertEquals(translator.createNotePitch("_A0"),Defs.Pitch.A0_FLAT);
        assertEquals(translator.createNotePitch("*F2"),Defs.Pitch.F2_SHARP);

    }

    @Test
    public void createtimeSigTest(){
        assertEquals(translator.createTimeSignature("4/4"),Defs.TimeSignature.FOUR_FOUR);
        assertEquals(translator.createTimeSignature("7/8"),Defs.TimeSignature.SEVEN_EIGHT);
    }
    @Test
    public void createNoteTypeTest(){
        assertEquals(translator.createNoteType("_A2"),Defs.NoteType.QUARTER);
        assertEquals(translator.createNoteType("_A4"),Defs.NoteType.HALF);
    }
    @Test
    public void extractNotesTest(){
        String abcPattern = "X: 1\n"
                + "T: " + "Woahhhhh" + "\n"
                + "M: " + "4/4" + "\n"
                + "L: " + "1/8" +"\n"
                + "R: reel" +"\n"
                + "K: " + "Gm" + "\n"
                + "_D4A4 B1C1|*F1 E1G1A1|";
        List<Note> notes = translator.extractNotes(translator.extractNoteMeasures(abcPattern));

        Note newNote = new Note(0,Defs.NoteType.HALF,Defs.Pitch.D4_FLAT,0,0);

        assertEquals(newNote.getFrequency(),notes.get(0).getFrequency());
        assertEquals(newNote.getMeasureId(),notes.get(0).getMeasureId());
        assertEquals(newNote.getMeasureIndex(),notes.get(0).getMeasureIndex());
        assertEquals(newNote.getPitch(),notes.get(0).getPitch());
        assertEquals(newNote.getType(),notes.get(0).getType());

    }

}
