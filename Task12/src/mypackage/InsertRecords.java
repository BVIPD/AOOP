package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecords {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "password");
            String sql = "INSERT INTO Registration (id, name, address, program) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 100);
            pstmt.setString(2, "Alice");
            pstmt.setString(3, "New York");
            pstmt.setString(4, "Computer Science");
            pstmt.executeUpdate();

            pstmt.setInt(1, 101);
            pstmt.setString(2, "Bob");
            pstmt.setString(3, "California");
            pstmt.setString(4, "Information Technology");
            pstmt.executeUpdate();

            pstmt.setInt(1, 102);
            pstmt.setString(2, "Charlie");
            pstmt.setString(3, "Texas");
            pstmt.setString(4, "Data Science");
            pstmt.executeUpdate();

            pstmt.setInt(1, 103);
            pstmt.setString(2, "David");
            pstmt.setString(3, "Florida");
            pstmt.setString(4, "Cyber Security");
            pstmt.executeUpdate();

            System.out.println("Records inserted successfully.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
