package projectakhir.note.test;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import projectakhir.note.app.core.data.note.NoteDB;
import projectakhir.note.app.core.data.note.NoteEntity;

@RunWith(JUnit4.class)
public class NoteDBTest {

    private NoteDB testNoteDBImpl;

    @Before
    public void setup() {
        testNoteDBImpl = new NoteDB();
    }

    private void insertNote() {
        testNoteDBImpl.getNotes().clear();
        testNoteDBImpl.insert("test1", "ini content test1", "2-5-2021", "kylix");
        testNoteDBImpl.insert("test2", "ini content test2", "30-4-2021", "kylix");
        testNoteDBImpl.insert("test3", "ini content test3", "1-1-2020", "usertest3");
    }

    @Test
    public void insertScenarioTest() {
        insertNote();
        Assertions.assertEquals(new NoteEntity("1","test1", "ini content test1", "2-5-2021", "kylix"), testNoteDBImpl.getAllNotes("kylix").get(0));
        Assertions.assertEquals(new NoteEntity("2", "test2", "ini content test2", "30-4-2021", "kylix"), testNoteDBImpl.getAllNotes("kylix").get(1));
        Assertions.assertEquals(new NoteEntity("3", "test3", "ini content test3", "1-1-2020", "usertest3"), testNoteDBImpl.getAllNotes("usertest3").get(0));
    }

    @Test
    public void updateScenarioTest() {
        insertNote();
        testNoteDBImpl.update("1", "test1", "menggantikan content test1", "22-5-2021", "kylix");
        Assertions.assertEquals(new NoteEntity("1", "test1", "menggantikan content test1", "22-5-2021", "kylix"), testNoteDBImpl.getAllNotes("kylix").get(0));

    }

    @Test
    public void deleteScenarioTest() {
        insertNote();
        testNoteDBImpl.delete("1");
        testNoteDBImpl.delete("2");
        Assertions.assertEquals(0, testNoteDBImpl.getAllNotes("kylix").size());
        Assertions.assertEquals(1, testNoteDBImpl.getAllNotes("usertest3").size());
    }

    @Test
    public void checkIdScenarioTest() {
        deleteScenarioTest();
        Assertions.assertFalse(testNoteDBImpl.isIdExist("1", "kylix"));
        Assertions.assertFalse(testNoteDBImpl.isIdExist("1", "usertest3"));
        Assertions.assertTrue(testNoteDBImpl.isIdExist("3", "usertest3"));
    }

    @Test
    public void getAllNotesScenarioTest() {
        insertNote();
        for (NoteEntity noteEntity: testNoteDBImpl.getNotes()) {
            System.out.println(noteEntity);
        }
    }
}
