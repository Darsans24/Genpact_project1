package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/ViewAccount")
public class ViewAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String accountNo = request.getParameter("accountNo"); // Updated parameter name

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "Darsan@24");

            ps = con.prepareStatement("SELECT * FROM customer WHERE account_no = ?");
            ps.setString(1, accountNo);
            rs = ps.executeQuery();

            out.println("<html><body>");
            if(rs.next()) {
                out.println("<h2>Customer Details</h2>");
                out.println("<p>Account No: " + rs.getString("account_no") + "</p>");
                out.println("<p>Full Name: " + rs.getString("full_name") + "</p>");
                out.println("<p>Address: " + rs.getString("address") + "</p>");
                out.println("<p>Mobile No: " + rs.getString("mobile_no") + "</p>");
                out.println("<p>Email ID: " + rs.getString("email_id") + "</p>");
                out.println("<p>Account Type: " + rs.getString("account_type") + "</p>");
                out.println("<p>Date of Birth: " + rs.getString("dob") + "</p>");
                out.println("<p>ID Proof: " + rs.getString("id_proof") + "</p>");
            } else {
                out.println("<p>No customer found with account number: " + accountNo + "</p>");
            }
            out.println("</body></html>");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception e) { e.printStackTrace(); }
            try { if(ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(); }
            try { if(con != null) con.close(); } catch(Exception e) { e.printStackTrace(); }
        }
    }
}
