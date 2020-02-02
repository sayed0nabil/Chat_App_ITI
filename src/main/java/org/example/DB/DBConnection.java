package org.example.DB;

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
        conn = DriverManager.getConnection(databaseInfo.getURL(), databaseInfo.getUser(), databaseInfo.getPassword());
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
