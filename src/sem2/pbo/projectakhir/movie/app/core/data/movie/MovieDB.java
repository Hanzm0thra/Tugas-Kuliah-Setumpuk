package sem2.pbo.projectakhir.movie.app.core.data.movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDB implements IMovieDB{

    List<MovieResponse> movies = new ArrayList<>();

    private List<MovieResponse> listAllMovies() {
        movies.add(new MovieResponse(
                1,
                "Stress Kuliah Daring",
                "Bagaimana rasanya kuliah daring? menyenangkan bukan? pastinya! " +
                        "\nHal itulah yang dirasakan semua siswa maupun mahasiswa di Indonesia" +
                        "\nTidur saat guru atau dosen mengajar menjadi hal yang wajar karena emang tidur itu nikamt dunia",
                "20-09-2020",
                "15 hours per day (Still Ongoing)",
                 0.0
        ));

        movies.add(new MovieResponse(
                2,
                "Drama UKT",
                "Tidak bisa membayar UKT? Biasalah namanya juga UB",
                "20-09-2020",
                "4 years",
                0.0
        ));

        return movies;
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        return listAllMovies();
    }

    @Override
    public MovieResponse getMovie(Integer id) {
        MovieResponse result = new MovieResponse(null, null, null, null, null, null);

        for (MovieResponse movie: movies) {
            if (movie.id().equals(id)){
                result = movie;
            }
        }
        return result;
    }

    @Override
    public void addMovie(String title, String subtitle, String releaseDate, String duration) {
        int id;
        if (movies.size() == 0)
            id = 1;
        else {
            int size = movies.size() - 1;
            id = movies.get(size).id() + 1;
        }

        movies.add(new MovieResponse(
                id,
                title,
                subtitle,
                releaseDate,
                duration,
                0.0
        ));
    }

    @Override
    public void deleteMovie(Integer id) {
        movies.removeIf(movie -> movie.id().equals(id));
    }

    @Override
    public void updateMovie(Integer id, String title, String subtitle, String releaseDate, String duration) {
        for (MovieResponse movie: movies) {
            if (movie.id().equals(id)){
                new MovieResponse(
                        id,
                        title,
                        subtitle,
                        releaseDate,
                        duration,
                        movie.rating()
                );
            }
        }
    }

    @Override
    public void updateRating(Integer id, Double rating) {
        Double currentRating = movies.get(id).rating();
        Double latestRating = (currentRating + rating) / movies.size();

        for (int index = 0; index < movies.size(); index++) {
            if (movies.get(index).id().equals(id)) {
                movies.set(index, new MovieResponse(
                        movies.get(index).id(),
                        movies.get(index).title(),
                        movies.get(index).subtitle(),
                        movies.get(index).releaseDate(),
                        movies.get(index).duration(),
                        latestRating
                ));
            }
        }
    }
}
