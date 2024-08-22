package service.UserService;

import dao.user.UserDao;
import entity.User;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor
public class UserService {
    private final UserDao userDao;
    public void saveUser(String name, String password) throws IOException {
        userDao.saveUser(insertUser(name, password));
    }
    public User getUser(String name, String password) throws IOException {
        User user = userDao.getUser(name,password);
        if(user == null)
            throw new NullPointerException();
        return user;
    }
    private User insertUser(String name, String password){
        return User.builder()
                .id(UUID.randomUUID())
                .name(name)
                .password(password)
                .build();
    }
}
