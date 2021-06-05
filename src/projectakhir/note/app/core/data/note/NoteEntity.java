package projectakhir.note.app.core.data.note;

public record NoteEntity(
        Integer id,
        String title,
        String content,
        String date,
        String author
) {
}
