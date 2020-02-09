package org.example.model;

import org.example.DB.DBConnection;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private RowSet rowSet=null;
    private Connection conn=null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    public UserDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
        statement = conn.createStatement();

    }
    @Override
    public List<User> getAllUsers() {
        List<User> users= new ArrayList<>();
        try {

            String sql = "select * from users";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                User user = extractUser(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        try {
            String sql = "select * from users where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                user = extractUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(int id, User user) {
        try{
            // You Must Add All Updated and Not Updated User Info In User Object
            String sql = "update users set" +
                    " id = ?" +
                    " ,phone_number = ?" +
                    " ,name = ?" +
                    " ,email = ?" +
                    " ,picture_path = ?" +
                    " ,password = ?" +
                    " ,gender = ?" +
                    " ,country = ?" +
                    " ,bio = ?" +
                    " ,date_of_birth = ?" +
                    " ,verified = ?" +
                    " ,chatbotoption = ?" +
                    " ,status_id = ?" +
                    " where id = " + id;
            preparedStatement = conn.prepareStatement(sql);
            injectUser(user);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0)
                return true;
            return false;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            String sql = "delete from users where id = " + id;
            int affectedRows = statement.executeUpdate(sql);
            if(affectedRows > 0){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUser(User user) {

        if(getUser(user.getId()) == null){
            try {
                String sql = "insert into users values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = conn.prepareStatement(sql);
                injectUser(user);
                int affectedRows = preparedStatement.executeUpdate();
                if(affectedRows > 0)
                    return true;
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    private User extractUser(ResultSet resultSet){
        try{
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setPhone(resultSet.getString(2));
            user.setName(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setImageURL(resultSet.getString(5));
            user.setPassword(resultSet.getString(6));
            Gender gender = Gender.Male;
            switch (resultSet.getString(7)){
                case "Female":
                    gender = Gender.Female;
                    break;
            }
            user.setGender(gender);
            user.setCountry(resultSet.getString(8));
            user.setBio(resultSet.getString(9));
            user.setDateOfBirth(resultSet.getDate(10));
            user.setVerified(resultSet.getBoolean(11));
            user.setChatbotOption(resultSet.getBoolean(12));
            UserStatus status = UserStatus.OFFLINE;
            switch ((resultSet.getInt(13))){
                case 1:
                    status = UserStatus.ONLINE;
                    break;
                case 2:
                    status = UserStatus.BUSY;
                    break;
            }
            user.setStatus(status);
            return user;
        }catch (SQLException e){
            return null;
        }
    }
    private void injectUser(User user){
        try{
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getImageURL());
            preparedStatement.setString(6, user.getPassword());
            Gender gender = user.getGender();
            String genderString = "Male";
            if(gender != null){
                switch (gender){
                    case Female:
                        genderString = "Female";
                        break;
                }
            }
            preparedStatement.setString(7, genderString);
            preparedStatement.setString(8, user.getCountry());
            preparedStatement.setString(9, user.getBio());
            // Convert Java.util.Date To Java.Sql.Date
//                preparedStatement.setDate(10, java.sql.Date.from(user.getDateOfBirth().toInstant()));
            preparedStatement.setDate(10, null);
            preparedStatement.setBoolean(11, user.isVerified());
            preparedStatement.setBoolean(12, user.isChatbotOption());
            UserStatus status = user.getStatus();
            int statusNumber = 0;
            if(status != null){
                switch (status){
                    case ONLINE:
                        statusNumber = 1;
                        break;
                    case BUSY:
                        statusNumber = 2;
                        break;
                }
            }
            preparedStatement.setInt(13, statusNumber);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
