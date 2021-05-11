package sem2.pbo.projectakhir.movie.app.core.data.user;

import sem2.pbo.projectakhir.movie.app.util.TypeOfUser;

public record UserEntity(
        String name,
        String email,
        String password,
        TypeOfUser type
) {
}
