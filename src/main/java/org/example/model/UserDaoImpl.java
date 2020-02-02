package org.example.model;

import javax.sql.RowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private RowSet rowSet=null;
    private Connection connection=null;
    @Override
    public List<User> getAllUsers() {
        String sql="Select * from user";
        return null;
    }

    @Override
    public User getUser(int id) {
        String sql="Select * from user where id="+id;

        return null;
    }

    @Override
    public User getUser(String name) {
        String sql="Select * from user where name= "+name;
        return null;
    }

    @Override
    public boolean updateUser(int id, User user) {

        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }
    private User extractUser(ResultSet resultSet){
        return null;
    }
}
