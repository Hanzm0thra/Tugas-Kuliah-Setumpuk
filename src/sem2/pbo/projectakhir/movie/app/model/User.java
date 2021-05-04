package sem2.pbo.projectakhir.movie.app.model;

import sem2.pbo.projectakhir.movie.app.util.TypeOfUser;

public record User(
        String name,
        String email,
        String password,
        TypeOfUser type
) {
}
