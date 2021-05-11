package sem2.pbo.projectakhir.movie.app.core.data.movie;

import java.util.List;

public interface IMovieDB {
    List<MovieResponse> getAllMovies();
    MovieResponse getMovie(Integer id);
    void addMovie(String title, String subtitle, String releaseDate, String duration);
    void deleteMovie(Integer id);
    void updateMovie(Integer id, String title, String subtitle, String releaseDate, String duration);
    void updateRating(Integer id, Double rating);
}
