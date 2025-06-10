package br.ifsp.infection.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory(Connection connection) {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        return connection;
    }

    public static PreparedStatement prepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
