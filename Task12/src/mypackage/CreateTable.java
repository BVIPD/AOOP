package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "password");
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Registration (" +
                         "id INT PRIMARY KEY, " +
                         "name VARCHAR(50), " +
                         "address VARCHAR(100), " +
                         "program VARCHAR(50))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
