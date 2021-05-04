package sem2.pbo.projectakhir.note.app.di;

import sem2.pbo.projectakhir.note.app.core.data.LoginDataSource;
import sem2.pbo.projectakhir.note.app.core.data.NoteDataSource;
import sem2.pbo.projectakhir.note.app.core.data.login.LoginBuilder;
import sem2.pbo.projectakhir.note.app.core.data.login.LoginClient;
import sem2.pbo.projectakhir.note.app.core.data.note.NoteBuilder;
import sem2.pbo.projectakhir.note.app.core.data.note.NoteDao;
import sem2.pbo.projectakhir.note.app.core.repository.INoteRepository;
import sem2.pbo.projectakhir.note.app.core.repository.NoteRepository;
import sem2.pbo.projectakhir.note.app.ui.HomeView;
import sem2.pbo.projectakhir.note.app.ui.LoginView;

public class Injection {

    //Login
    public static LoginClient provideLoginDB = LoginBuilder.getInstance();
    public static LoginDataSource provideLoginDataSource = new LoginDataSource(provideLoginDB);

    //Note
    public static NoteDao provideNoteDB = NoteBuilder.getInstance();
    public static NoteDataSource provideNoteDataSource = new NoteDataSource(provideNoteDB);

    //Repository
    public static INoteRepository provideNoteRepository = new NoteRepository(provideLoginDataSource, provideNoteDataSource);

    //View
    public static LoginView provideLoginView = new LoginView(provideNoteRepository);
    public static HomeView provideHomeView = new HomeView(provideNoteRepository, provideLoginView);
}
