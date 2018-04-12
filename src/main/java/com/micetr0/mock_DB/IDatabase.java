package com.micetr0.mock_DB;

import com.micetr0.Credential;
import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import com.micetr0.model.Note;

import java.util.List;
import java.util.Map;

public interface IDatabase {
    /**
     *
     * @param note
     */
    void insertNote(Note note);

    /**
     *
     * @param noteId
     */
    void deleteNote(String noteId);

    /**
     * Multiple notes can exist in the same index in a measure (for a chord), so noteId is the only way to properly
     * distinguish notes
     * @param measureId
     * @param measureIndex
     * @return
     */
    List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex);

    /**
     *
     * @param accountId
     * @return
     */
    List<Composition> findCompositionsIdsByAccountId(Integer accountId);
//List<Note> findNotesByMeasureId(Integer measureId);

    /**
     *
     * @return
     */
    List<Account> findAllAccounts();

    /**
     *
     * @param accountId
     * @return
     */
    List<Account> findCurrentAccount(Integer accountId);

    /**
     *
     * @param composition
     */
    void insertComposition(Composition composition);

    /**
     *
     * @param compositionId
     */
    void deleteComposition(Integer compositionId);

    /**
     *
     * @param username
     */
    void deleteAccount(String username);

    /**
     *
     * @return
     */
    List<Composition> findAllComps();

    /**
     *
     * @param account
     */
    void insertAccount(Account account);

    /**
     *
     * @param username
     * @return
     */
    List<Integer> findAccountIdByUsername(String username);

    /**
     * Returns list of usernames and passwords for given account ID
     * Map.Entry is compatible with OpenJDK
     * @param accountId
     * @return Map.Entry<K, V> (key-value pair) with K being username and V being password
     */
    List<Credential> findUsernameAndPasswordByAccountId(Integer accountId);

    /**
     * Used to verify that username and password combination (login) has an account ID entry in db
     * @param username User's unique username
     * @param password User's password, associated only with username and account and not unique in db
     * @return List of Account IDs with given username and password
     */
    List<Integer> findAccountIdByUsernameAndPassword(String username, String password);
}
