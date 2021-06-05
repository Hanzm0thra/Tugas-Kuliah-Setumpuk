package sem2.pbo.projectakhir.noteX.app.core.data.note;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteDB implements NoteDao {

    private List<NoteEntity> notes = new ArrayList<>();

    @Override
    public void insert(String title, String content, String date, String author) {
        int id;
        if (notes.size() == 0)
            id = 1;
        else {
            int size = notes.size() - 1;
            id = notes.get(size).id() + 1;
        }

        File noteFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Project Akhir\\Notes.txt");
        try {
            FileWriter writer = new FileWriter(noteFile);
            String data = id + "-" + title + "-" + content + "-" + date + "-" + author ;
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        notes.removeIf(obj -> obj.id().equals(id));
        rewriteNotes();
    }

    @Override
    public void update(Integer id, String title, String content, String date, String author) {
        for (int index = 0; index < notes.size(); index++) {
            if (notes.get(index).id().equals(id)) {
                notes.set(index, new NoteEntity(
                        notes.get(index).id(),
                        title,
                        content,
                        date,
                        author
                ));
            }
        }

        rewriteNotes();
    }

    @Override
    public List<NoteEntity> getAllNotes(String author) {
        List<NoteEntity> selectedNote = new ArrayList<>();

        for (NoteEntity obj: notes) {
            if (obj.author().equals(author))
                selectedNote.add(obj);
        }

        return selectedNote;
    }

    @Override
    public boolean isIdExist(Integer id, String author) {
        boolean isExist = false;

        for (NoteEntity obj: notes) {
            if (obj.id().equals(id) && obj.author().equals(author)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public NoteDB noteBuild() {
        try {
            File noteFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Project Akhir\\Notes.txt");
            if (!noteFile.exists())
                noteFile.createNewFile();

            Scanner read = new Scanner(noteFile);
            while (read.hasNextLine())
                fileBreakdown(read.nextLine());

            read.close();
            System.out.println(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new NoteDB();
    }

    private void fileBreakdown(String data) {
        String[] arr = data.split("[-\n]");
        notes.add(new NoteEntity(
                Integer.parseInt(arr[0]),
                arr[1],
                arr[2],
                arr[3],
                arr[4]
        ));
    }

    private void deleteAllContent() {
        File noteFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Project Akhir\\Notes.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(noteFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert writer != null;
        writer.print("");
        writer.close();
    }

    private void rewriteNotes() {
        deleteAllContent();
        File noteFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Project Akhir\\Notes.txt");
        try {
            FileWriter writer = new FileWriter(noteFile);
            for (NoteEntity obj: notes) {
                String data = obj.id() + "-" + obj.title() + "-" + obj.content() + "-" + obj.date() + "-" + obj.author();
                writer.write(data + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<NoteEntity> getNotes() {
        return notes;
    }
}
