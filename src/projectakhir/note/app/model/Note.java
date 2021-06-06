package projectakhir.note.app.model;

public record Note(
        String id,
        String title,
        String content,
        String date,
        String author
) { }
