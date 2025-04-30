package mypackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ContactDB";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "yourpassword";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");

        if (name == null || email == null || phone == null || name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            response.getWriter().println("Error: All fields except message are required!");
            return;
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "INSERT INTO contacts (name, email, phone, message) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, message);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            response.getWriter().println("Contact details submitted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: Unable to save details.");
        }
    }
}
