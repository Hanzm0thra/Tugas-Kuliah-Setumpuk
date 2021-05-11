package sem2.pbo.projectakhir.movie.app.core.data.movie;

public record MovieResponse(
        Integer id,
        String title,
        String subtitle,
        String releaseDate,
        String duration,
        Double rating
) {
}
