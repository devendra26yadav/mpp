package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBConnection {

    public static Connection getConnection(){
        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            String password = "";
            String user = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/university?useSSL=false&serverTimezone=America/Chicago";
            return DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
