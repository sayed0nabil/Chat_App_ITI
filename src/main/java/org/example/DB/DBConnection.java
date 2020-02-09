package org.example.DB;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;
    private static DatabaseInfo databaseInfo;

    private static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error: " + cnfe.getMessage());
        }
        //databaseInfo=new DatabaseInfoDialog().showAndWait().get();
//        databaseInfo = new DatabaseInfo("jdbc:mysql://localhost:3306/chat_app", "root", "root");
//        conn = DriverManager.getConnection(databaseInfo.getURL(), databaseInfo.getUser(), databaseInfo.getPassword());

        DataSource dataSource = MyDataSourceFactory.getMySQLDataSource();
        conn = dataSource.getConnection();
        return conn;
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            synchronized (DBConnection.class) {
                if (conn == null) {
                    connect();
                }
            }
        }
        return conn;
    }
}
