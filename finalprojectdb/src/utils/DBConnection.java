package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // JDBC URL, username and password
    private static final String URL = "jdbc:mysql://localhost:3306/finalprojectdb?serverTimezone=America/Chicago&useSSL=false";

    //for testing automatic table creations and insertions
    //private static final String URL = "jdbc:mysql://localhost:3306/automatictablesdb?serverTimezone=America/Chicago&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    // Private constructor to prevent instantiation
    private DBConnection() {}

    /**
     * Returns a singleton database connection
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    /**
     * Close the connection safely
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
