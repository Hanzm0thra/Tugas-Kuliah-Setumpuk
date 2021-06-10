package projectakhir.note.app.di;


import projectakhir.note.app.core.data.LoginDataSource;
import projectakhir.note.app.core.data.NoteDataSource;
import projectakhir.note.app.core.data.login.LoginBuilder;
import projectakhir.note.app.core.data.login.LoginDao;
import projectakhir.note.app.core.data.note.NoteBuilder;
import projectakhir.note.app.core.data.note.NoteDao;
import projectakhir.note.app.core.repository.INoteRepository;
import projectakhir.note.app.core.repository.NoteRepository;

public class Injection {

    //Login
    public static LoginDao provideLoginDao = LoginBuilder.getInstance();
    public static LoginDataSource provideLoginDataSource = LoginDataSource.getInstance(provideLoginDao);

    //Note
    public static NoteDao provideNoteDao = NoteBuilder.getInstance();
    public static NoteDataSource provideNoteDataSource = NoteDataSource.getInstance(provideNoteDao);

    //Repository
    public static INoteRepository provideNoteRepository = NoteRepository.getInstance(provideLoginDataSource, provideNoteDataSource);

}
