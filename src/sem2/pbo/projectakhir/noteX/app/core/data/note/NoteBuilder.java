package sem2.pbo.projectakhir.noteX.app.core.data.note;

public class NoteBuilder extends NoteDB {

    private static NoteDB INSTANCE;

    public static NoteDB getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NoteDB().noteBuild();
        return INSTANCE;
    }

}
