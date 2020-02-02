package org.example.DB;

public class DatabaseInfo {
    private String URL;
    private String user;
    private String Password;

    public DatabaseInfo() {
        URL = "jdbc:mysql://localhost:3306";
        user = "root";
    }

    public DatabaseInfo(String URL, String user, String password) {
        this.URL = URL;
        this.user = user;
        Password = password;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
