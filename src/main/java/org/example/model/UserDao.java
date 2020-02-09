package org.example.model;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(int id);

    User getUser(String name);

    boolean updateUser(int id, User user);

    boolean deleteUser(int id);

    boolean addUser(User user);

}