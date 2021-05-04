package sem2.pbo.projectakhir.note.test.note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sem2.pbo.projectakhir.note.app.core.data.note.NoteDB;
import sem2.pbo.projectakhir.note.app.core.data.note.NoteEntity;
import sem2.pbo.projectakhir.note.test.di.FakeInjection;

public class TestNoteDB {

    NoteDB testNoteDB = FakeInjection.provideFakeNoteDB;

    private void insertNote() {
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
        insertScenarioTest();
        testNoteDB.update(1, "test1", "menggantikan content test1", "22-5-2021", "kylix");
        Assertions.assertEquals(new NoteEntity(1, "test1", "menggantikan content test1", "22-5-2021", "kylix"), testNoteDB.getAllNotes("kylix").get(0));

    }

    @Test
    public void deleteScenarioTest() {

    }

    @Test
    public void checkIdScenarioTest() {

    }

    @Test
    public void getAllNotesScenarioTest() {

    }
}
