package service.UserService;

import dao.user.UserDao;
import entity.User;
import lombok.AllArgsConstructor;
import service.Service;

import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor
public class UserService implements Service {
    private final UserDao userDao;

    public void saveUser(String name, String password) throws IOException {
        userDao.saveUser(insertUser(name,password));
    }

    public User getUser(String name, String password) throws IOException {
        User user = getUserForBase(name,password);
        if(user == null)
            throw new NullPointerException();
        return user;
    }
    private User getUserForBase(String name, String password) throws IOException {
        return userDao.getAllUsers().stream()
                .filter(n-> n.getName().equals(name) && n.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    private User insertUser(String name, String password){
        return User.builder()
                .id(UUID.randomUUID())
                .name(name)
                .password(password)
                .build();
    }
}
