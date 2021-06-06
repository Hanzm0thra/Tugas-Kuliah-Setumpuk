package projectakhir.note.app.core.repository;


import projectakhir.note.app.core.data.LoginDataSource;
import projectakhir.note.app.core.data.NoteDataSource;
import projectakhir.note.app.core.data.Resource;
import projectakhir.note.app.core.data.login.LoginResponse;
import projectakhir.note.app.core.data.note.NoteEntity;
import projectakhir.note.app.model.Login;
import projectakhir.note.app.model.Note;
import projectakhir.note.app.util.Mapper;

import java.util.List;

public class NoteRepository implements INoteRepository {

    private LoginDataSource loginDataSource;
    private NoteDataSource noteDataSource;

    public NoteRepository(LoginDataSource loginDataSource, NoteDataSource noteDataSource) {
        this.loginDataSource = loginDataSource;
        this.noteDataSource = noteDataSource;
    }

    @Override
    public Login getAccount(String email, String password) {
        return new Resource<LoginResponse, Login>() {
            @Override
            public Login loadData(LoginResponse data) {
                return Mapper.mappingLogin(data);
            }

            @Override
            public LoginResponse call() {
                return loginDataSource.getAccount(email, password);
            }


        }.asResult();
    }

    @Override
    public boolean isEmailAlreadyExist(String email) {
        return loginDataSource.isEmailAlreadyExist(email);
    }

    @Override
    public boolean isNameAlreadyExist(String name) {
        return loginDataSource.isNameAlreadyExist(name);
    }

    @Override
    public void register(String email, String password, String name) {
        loginDataSource.register(email, password, name);
    }

    @Override
    public void insert(String title, String content, String date, String author) {
        noteDataSource.insert(title, content, date, author);
    }

    @Override
    public void delete(Integer id) {
        noteDataSource.delete(id);
    }

    @Override
    public void update(Integer id, String title, String content, String date, String author) {
        noteDataSource.update(id, title, content, date, author);
    }

    @Override
    public List<Note> getAllNotes(String author) {
        return new Resource<List<NoteEntity>, List<Note>>() {

            @Override
            public List<Note> loadData(List<NoteEntity> data) {
                return Mapper.mappingNotes(data);
            }

            @Override
            public List<NoteEntity> call() {
                return noteDataSource.getAllNotes(author);
            }
        }.asResult();
    }

    @Override
    public Note getSelectedNote(Integer id) {
        return new Resource<NoteEntity, Note>() {
            @Override
            public Note loadData(NoteEntity data) {
                return Mapper.mappingNote(data);
            }

            @Override
            public NoteEntity call() {
                return noteDataSource.getSelectedNote(id);
            }
        }.asResult();
    }

    @Override
    public boolean isIdExist(Integer id, String author) {
        return noteDataSource.isIdExist(id, author);
    }
}
