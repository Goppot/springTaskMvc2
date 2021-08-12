package dbweb.dao;

import dbweb.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, User usr);

    void deleteUser(int id);

}
