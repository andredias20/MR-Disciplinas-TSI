package org.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionFactory implements IConnectionFactory {
    public static Connection getConnection(String host, String database, String user, String password) throws SQLException {
        String url = "jdbc:postgresql://" + host + "/" + database;
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
