package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLFileExecutor {

    public static void executeSQLFile(String filePath) {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            StringBuilder sql = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                // Skip empty lines or comments
                if (line.isEmpty() || line.startsWith("--")) continue;

                sql.append(line).append(" ");
                // Execute when a semicolon is found
                if (line.endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0); // clear the buffer
                }
            }

            System.out.println("SQL file executed successfully!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
