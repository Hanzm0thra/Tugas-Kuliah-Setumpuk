package sem2.pbo.projectakhir.note.test.di;

import sem2.pbo.projectakhir.note.test.login.FakeLoginDB;
import sem2.pbo.projectakhir.note.test.note.FakeNoteDB;

public class FakeInjection {

    public static FakeLoginDB provideFakeLoginDB = new FakeLoginDB();
    public static FakeNoteDB provideFakeNoteDB = new FakeNoteDB();
}
