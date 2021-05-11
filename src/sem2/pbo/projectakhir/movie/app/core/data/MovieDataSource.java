package sem2.pbo.projectakhir.movie.app.core.data;

import sem2.pbo.projectakhir.movie.app.core.data.movie.IMovieDB;
import sem2.pbo.projectakhir.movie.app.core.data.movie.MovieResponse;

import java.util.List;

public class MovieDataSource {
    private IMovieDB movieDB;

    public MovieDataSource(IMovieDB movieDB) {
        this.movieDB = movieDB;
    }

    public List<MovieResponse> getAllMovies() {
        return movieDB.getAllMovies();
    }

    public MovieResponse getMovie(Integer id) {
        return movieDB.getMovie(id);
    }

    public void addMovie(String title, String subtitle, String releaseDate, String duration) {
        movieDB.addMovie(title, subtitle, releaseDate, duration);
    }

    public void deleteMovie(Integer id) {
        movieDB.deleteMovie(id);
    }

    public void updateMovie(Integer id, String title, String subtitle, String releaseDate, String duration) {
        movieDB.updateMovie(id, title, subtitle, releaseDate, duration);
    }

    public void updateRating(Integer id, Double rating) {
        movieDB.updateRating(id, rating);
    }
}
