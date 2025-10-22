package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

   // private static final String URL = "jdbc:mysql://localhost:3306/mppfinalproject?serverTimezone=America/Chicago&useSSL=false";
   private static final String URL = "jdbc:mysql://localhost:3306/finalprojectdb?serverTimezone=America/Chicago&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
