package sem2.pbo.projectakhir.movie.app.core.data.movie;

public class MovieBuilder extends MovieDB {
    private static MovieBuilder INSTANCE;

    public static MovieBuilder getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MovieBuilder();
        return INSTANCE;
    }
}
