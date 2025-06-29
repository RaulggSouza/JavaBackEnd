package br.ifsp.infection.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        return connection;
    }

    public static PreparedStatement createPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    public void closeConnection() throws SQLException {
        getConnection().close();
    }
}
