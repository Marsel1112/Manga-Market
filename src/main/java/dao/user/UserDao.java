package dao.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
@RequiredArgsConstructor
public class UserDao{
    private final ObjectMapper objectMapper;
    private final File file;
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        objectMapper.writeValue(file,users);
    }
    public User getUser(String name, String password) throws IOException {
        User user;
        try {
            user =  getAllUsers()
                    .stream().filter(n -> n.getName().equals(name) && n.getPassword().equals(password))
                    .findFirst()
                    .get();
        }catch (NoSuchElementException e){
            throw new NullPointerException();
        }
        return user;

    }
    private List<User> getAllUsers() throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<User>>() {
        });
    }
}
