package sem2.pbo.projectakhir.noteX.test.di;

import sem2.pbo.projectakhir.noteX.test.login.FakeLoginDB;
import sem2.pbo.projectakhir.noteX.test.note.FakeNoteDB;

public class FakeInjection {

    public static FakeLoginDB provideFakeLoginDB = new FakeLoginDB();
    public static FakeNoteDB provideFakeNoteDB = new FakeNoteDB();
}
