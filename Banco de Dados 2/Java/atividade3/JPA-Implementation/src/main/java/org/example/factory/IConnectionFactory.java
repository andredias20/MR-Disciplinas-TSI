package org.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {
    Connection getConnection(String host, String database, String user, String password) throws SQLException;
}
