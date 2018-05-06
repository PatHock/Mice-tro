package com.micetr0;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Account;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import com.micetr0.model.Composition;
import com.micetr0.model.Note;
import com.micetr0.model.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

public class AbcTranslatorTest {

    AbcTranslator translator;
    @BeforeEach
    public void setUp(){
        translator = new AbcTranslator();

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
        Section section = new Section();
        section.setKey(Defs.Key.C_MAJOR);
        section.setTimeSig(Defs.TimeSignature.FOUR_FOUR);
        Note note = new Note(0,Defs.NoteType.HALF,Defs.Pitch.A0_SHARP,0,0);
        Note note2 = new Note(1,Defs.NoteType.HALF,Defs.Pitch.A1_FLAT,1,0);
        List<Note> notes = new ArrayList<>();
        notes.add(note);
        notes.add(note2);
        Composition comp = new Composition();
        comp.setTitle("title");

        String out = translator.abcBuilder(comp,section, notes);

        assertEquals(out,"X: 1\n"
                + "T: " + translator.getCompTitle(comp) + "\n"
                + "M: " + translator.getTimeSig(section) + "\n"
                + "L: 1/8 \n"
                + "R: reel \n"
                + "K: " + translator.getKey(section) + "\n"
                + " | "
                + translator.getNote(notes.get(0))
                + " "
                + translator.getNote(notes.get(1))
                + "|");
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
}
