package projectakhir.note.app.model;

public record Note(
        Integer id,
        String title,
        String content,
        String date,
        String author
) { }
