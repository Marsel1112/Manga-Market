package dao.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BaseDao;
import entity.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class UserDao extends BaseDao<User> {

    public UserDao(ObjectMapper objectMapper, File file, TypeReference<List<User>> typeReference) {
        super(objectMapper, file,typeReference);
    }

    public void saveUser(User user) throws IOException {
        List<User> users = getAllEntity();
        users.add(user);
        writeToFile(users);
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users;
        try {
            users =  getAllEntity();
        }catch (NoSuchElementException e){
            throw new NullPointerException();
        }
        return users;
    }


}
