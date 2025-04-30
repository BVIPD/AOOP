package mypackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecords {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "password");
            String sql = "UPDATE Registration SET program = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Software Engineering");
            pstmt.setInt(2, 100);
            pstmt.executeUpdate();

            pstmt.setString(1, "Artificial Intelligence");
            pstmt.setInt(2, 101);
            pstmt.executeUpdate();

            System.out.println("Records updated successfully.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
