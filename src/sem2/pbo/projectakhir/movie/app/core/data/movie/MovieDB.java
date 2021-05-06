package sem2.pbo.projectakhir.movie.app.core.data.movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDB {

    List<MovieResponse> movieCollection = new ArrayList<>();

    private List<MovieResponse> listAllMovies() {
        movieCollection.add(new MovieResponse(
                1,
                "Stress Kuliah Daring",
                "Bagaimana rasanya kuliah daring? menyenangkan bukan? pastinya! " +
                        "\nHal itulah yang dirasakan semua siswa maupun mahasiswa di Indonesia" +
                        "\nTidur saat guru / dosen mengajar menjadi hal yang wajar karena emang tidur itu nikamt dunia",
                "20-09-2020",
                "15 hours per day (Still Ongoing)",
                 0.0
        ));

        movieCollection.add(new MovieResponse(
                2,
                "Drama UKT",
                "Tidak bisa membayar UKT? Biasalah namanya juga UB",
                "20-09-2020",
                "4 years",
                0.0
        ));

        return movieCollection;
    }
}
