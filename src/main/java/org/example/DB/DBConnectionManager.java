package org.example.DB;

import java.sql.Connection;

public interface DBConnectionManager {
    Connection getConnection();
}
