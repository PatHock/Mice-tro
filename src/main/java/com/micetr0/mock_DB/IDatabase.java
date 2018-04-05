package com.micetr0.mock_DB;

import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import com.micetr0.model.Note;
import java.util.List;

public interface IDatabase {

void insertNote(Note note);

void deleteNote(String noteId);

List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex);

List<Composition> findCompositionsIdsByAccountId(Integer accountId);

List<Account> findAllAccounts();
}
