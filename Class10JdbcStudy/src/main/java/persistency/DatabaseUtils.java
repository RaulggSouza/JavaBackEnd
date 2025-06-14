package persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtils {
    private static Connection connection;

    private DatabaseUtils() {}

    public static Connection getConnection() throws SQLException {
        if(connection == null) connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        return connection;
    }

    public static PreparedStatement createPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    public static void closeConnection() throws SQLException {
        if(!connection.isClosed()) connection.close();
    }

    public static void disableAutoCommit() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    public static void ableAutoCommit() throws SQLException {
        getConnection().setAutoCommit(true);
    }

    public static void commitChanges() throws SQLException {
        connection.commit();
    }

    public static void rollback() throws SQLException {
        connection.rollback();
    }
}
