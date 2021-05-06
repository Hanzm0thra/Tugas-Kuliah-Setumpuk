package sem2.pbo.projectakhir.movie.app.core.data.movie;

public record MovieResponse(
        int id,
        String title,
        String subtitle,
        String releaseDate,
        String duration,
        double rating
) {
}
