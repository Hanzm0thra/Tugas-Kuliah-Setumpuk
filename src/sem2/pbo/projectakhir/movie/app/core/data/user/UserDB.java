package sem2.pbo.projectakhir.movie.app.core.data.user;

import sem2.pbo.projectakhir.movie.app.util.TypeOfUser;

import java.util.ArrayList;
import java.util.List;

public class UserDB implements IUserDB {
    private List<UserEntity> userCollection = new ArrayList<>();

    private List<UserEntity> listAllUsers() {
        userCollection.add(new UserEntity(
                "kylix",
                "kylix@gmail.com",
                "100902",
                TypeOfUser.NORMAL
        ));

        userCollection.add(new UserEntity(
                "admin1",
                "admin1@gmail.com",
                "12345",
                TypeOfUser.ADMIN
        ));

        return userCollection;
    }


    @Override
    public UserEntity getAllUsers(String email, String password) {
        UserEntity result = new UserEntity(null, null, null, TypeOfUser.DEFAULT);

        for (UserEntity obj: userCollection) {
            if (obj.email().equals(email) && obj.password().equals(password)) {
                result = new UserEntity(
                        obj.name(),
                        obj.email(),
                        obj.password(),
                        obj.type()
                );
            }
        }

        return result;
    }

    @Override
    public boolean isNameAlreadyExist(String name) {
        return userCollection.stream().anyMatch(userEntity -> userEntity.name().equals(name));
    }

    @Override
    public boolean isEmailAlreadyExist(String email) {
        return userCollection.stream().anyMatch(userEntity -> userEntity.email().equals(email));
    }

    @Override
    public void register(String name, String email, String password) {
        userCollection.add(new UserEntity(
                name,
                email,
                password,
                TypeOfUser.DEFAULT
        ));
    }
}
