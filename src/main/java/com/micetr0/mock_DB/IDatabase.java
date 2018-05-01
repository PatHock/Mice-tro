package com.micetr0.mock_DB;

import com.micetr0.Credential;
import com.micetr0.definitions.Defs;
import com.micetr0.model.*;

import java.util.List;
import java.util.Map;

public interface IDatabase {
    /**
     *
     * @param type
     */
    Integer insertNote(String type, String pitch, Integer measureIndex, Integer measureId);

    /**
     *
     * @param noteId Unique ID that is stored in the database
     */
    Boolean deleteNote(Integer noteId);

    List<Composition> findCompositionsByAccountId(Integer accountId);

    /**
     * Multiple notes can exist in the same index in a measure (for a chord), so noteId is the only way to properly
     * distinguish notes
     * @param measureId Unique measure ID as stored in the database
     * @param measureIndex Position of a note within a Measure. Starts at 0
     * @return List of notes at this index
     */
    List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex);

    /**
     *
     * @param accountId Unique ID for account as stored in database.
     * @return List of compositions
     */

//List<Note> findNotesByMeasureId(Integer measureId);

    /**
     *
     * @return a list containing an account object for every account stored in the db
     */
    List<Account> findAllAccounts();

    /**
     *
     * @param accountId unique identifier for accounts.
     * @return list of accounts
     */
    List<Account> findAccountByAccountID(Integer accountId);


    /**
     *
     * @param compositionId Unique Id for composition.
     * @return isCompDeleted: true if deletion was successful, false if deletion failed (composition did
     * not exist, etc
     */
    Boolean deleteComposition(Integer compositionId);

    /**
     *
     * @param username String - a user's unique username as entered at login
     */
    Boolean deleteAccount(String username);

    /**
     *
     * @return list of all composition objects contained in the database
     */
    List<Composition> findAllComps();

    /**
     *
     * @param  username
     */
    Integer insertAccount(String username, String password);

    /**
     *
     * @param username String - a user's unique username as entered at login
     * @return List of account IDs that are paired with given username
     */
    List<Account> findAccountByUsername(String username);

    /**
     *
     * @param compositionId Unique database-specific identification for a composition
     * @param description A user-editable description for the composition
     * @return Boolean isCompUpdated: True when update operation is successful, false otherwise
     */
    Boolean updateCompositionDescriptionByCompositionId(Integer compositionId, String description);

    /**
     *
     * @param compositionId Unique Identifier for compositions.
     * @param title The title of a composition. Editable by the user.
     * @return Boolean isCompUpdated: True when update operation is successful, false otherwise
     */
    Boolean updateCompositionTitleByCompositionId(Integer compositionId, String title);

//    /**
//     * Returns list of usernames and passwords for given account ID
//     * Map.Entry is compatible with OpenJDK
//     * @param accountId
//     * @return Map.Entry<K, V> (key-value pair) with K being username and V being password
//     */
//    List<Credential> findUsernameAndPasswordByAccountId(Integer accountId);

    /**
     * Used to verify that username and password combination (login) has an account ID entry in db
     * @param username User's unique username
     * @param password User's password, associated only with username and account and not unique in db
     * @return List of Account IDs with given username and password
     */
    List<Account> findAccountByUsernameAndPassword(String username, String password);

    /**
     *
     * @param compositionId Unique ID that distinguishes a composition from others in the database.
     * @return an ArrayList of Composition objects that match the given composition ID
     */
    List<Composition> findCompositionsByCompositionId(Integer compositionId);

    /**
     *
     * @param compositionId Unique Identifier for compositions.
     * @param year Integer year when the composition was written
     * @return Boolean, true indicates that update was successful, false indicates that update failed (invalid composition ID)
     */
    Boolean updateCompositionYearByCompositionId(Integer compositionId, Integer year);

    /**
     * Creates a composition from given title, description, and year. Generates unique ID
     * @param title The name of the composition.
     * @param description A string that describes the purpose etc of the composition
     * @param year The year the composition was written
     * @return A composition object with unique ID
     */
    Integer insertComposition(String title, String description, Integer year, Integer isViewablePublicly, Integer accountId);



    /**
     * create db access from front end. Ease to create and remove db
     */
    void deleteDB();

    void createDB();

    Boolean insertSection(Integer sectionID, Defs.Key key, Defs.TimeSignature timeSig, Defs.Clef clef, Integer tempo, Integer composition_ID);

    Boolean deleteSection(Integer sectionID);

    Section findSectionFromSectionID(Integer sectionID);

    List<Section> findAllSections();

    List<Section> findSectionsByCompositionId(Integer compositionId);

    List<Measure> findMeasuresBySectionId(Integer SectionId);

}
