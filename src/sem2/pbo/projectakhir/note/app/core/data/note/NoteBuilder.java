package sem2.pbo.projectakhir.note.app.core.data.note;

public class NoteBuilder extends NoteDB{

    private static NoteBuilder INSTANCE;

    public static NoteBuilder getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NoteBuilder();
        return INSTANCE;
    }

}
