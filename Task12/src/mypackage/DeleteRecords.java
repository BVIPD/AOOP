package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteRecords {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "password");
            String sql = "DELETE FROM Registration WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 101);
            pstmt.executeUpdate();

            System.out.println("Record deleted successfully.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
