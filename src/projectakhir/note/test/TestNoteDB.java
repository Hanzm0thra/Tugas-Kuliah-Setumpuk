package projectakhir.note.test;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import projectakhir.note.app.core.data.note.NoteDB;
import projectakhir.note.app.core.data.note.NoteEntity;

@RunWith(JUnit4.class)
public class TestNoteDB {

    private NoteDB testNoteDB;

    @Before
    public void setup() {
        testNoteDB = new NoteDB();
    }

    private void insertNote() {
        testNoteDB.getNotes().clear();
        testNoteDB.insert("test1", "ini content test1", "2-5-2021", "kylix");
        testNoteDB.insert("test2", "ini content test2", "30-4-2021", "kylix");
        testNoteDB.insert("test3", "ini content test3", "1-1-2020", "usertest3");
    }

    @Test
    public void insertScenarioTest() {
        insertNote();
        Assertions.assertEquals(new NoteEntity(1,"test1", "ini content test1", "2-5-2021", "kylix"), testNoteDB.getAllNotes("kylix").get(0));
        Assertions.assertEquals(new NoteEntity(2, "test2", "ini content test2", "30-4-2021", "kylix"), testNoteDB.getAllNotes("kylix").get(1));
        Assertions.assertEquals(new NoteEntity(3, "test3", "ini content test3", "1-1-2020", "usertest3"), testNoteDB.getAllNotes("usertest3").get(0));
    }

    @Test
    public void updateScenarioTest() {
        insertNote();
        testNoteDB.update(1, "test1", "menggantikan content test1", "22-5-2021", "kylix");
        Assertions.assertEquals(new NoteEntity(1, "test1", "menggantikan content test1", "22-5-2021", "kylix"), testNoteDB.getAllNotes("kylix").get(0));

    }

    @Test
    public void deleteScenarioTest() {
        insertNote();
        testNoteDB.delete(1);
        testNoteDB.delete(2);
        Assertions.assertEquals(0, testNoteDB.getAllNotes("kylix").size());
        Assertions.assertEquals(1, testNoteDB.getAllNotes("usertest3").size());
    }

    @Test
    public void checkIdScenarioTest() {
        deleteScenarioTest();
        Assertions.assertFalse(testNoteDB.isIdExist(1, "kylix"));
        Assertions.assertFalse(testNoteDB.isIdExist(1, "usertest3"));
        Assertions.assertTrue(testNoteDB.isIdExist(3, "usertest3"));
    }

    @Test
    public void getAllNotesScenarioTest() {
        insertNote();
        for (NoteEntity noteEntity: testNoteDB.getNotes()) {
            System.out.println(noteEntity);
        }
    }
}
