package sem2.pbo.projectakhir.movie.app.model;

public record Movie(
        int id,
        String title,
        String subtitle,
        String releaseDate,
        String duration,
        double rating
) {
}
