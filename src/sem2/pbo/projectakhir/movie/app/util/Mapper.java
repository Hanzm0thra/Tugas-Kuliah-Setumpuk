package sem2.pbo.projectakhir.movie.app.util;

import sem2.pbo.projectakhir.movie.app.core.data.movie.MovieResponse;
import sem2.pbo.projectakhir.movie.app.core.data.user.UserEntity;
import sem2.pbo.projectakhir.movie.app.model.Movie;
import sem2.pbo.projectakhir.movie.app.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static List<Movie> mapMovies(List<MovieResponse> list) {
        return list.stream()
                .map( movieResponse -> new Movie(
                        movieResponse.id(),
                        movieResponse.title(),
                        movieResponse.subtitle(),
                        movieResponse.releaseDate(),
                        movieResponse.duration(),
                        movieResponse.rating()
                ))
                .collect(Collectors.toList());
    }

    public static Movie mapMovie(MovieResponse data) {
        return new Movie(
                data.id(),
                data.title(),
                data.subtitle(),
                data.releaseDate(),
                data.duration(),
                data.rating()
        );
    }

    public static List<User> mapUsers(List<UserEntity> list) {
        return list.stream()
                .map(userEntity -> new User(
                        userEntity.name(),
                        userEntity.email(),
                        userEntity.password(),
                        userEntity.type()
                ))
                .collect(Collectors.toList());
    }

    public static User mapUser(UserEntity data) {
        return new User(
                data.name(),
                data.email(),
                data.password(),
                data.type()
        );
    }
}