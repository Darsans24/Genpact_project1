package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/ModifyAccount")
public class ModifyAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String accountNo = request.getParameter("accountNo");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String mobileNo = request.getParameter("mobileNo");
        String emailId = request.getParameter("emailId");
        String accountType = request.getParameter("accountType");
        String dob = request.getParameter("dob");
        String idProof = request.getParameter("idProof");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "Darsan@24");

            ps = con.prepareStatement("UPDATE customer SET full_name=?, address=?, mobile_no=?, email_id=?, account_type=?, dob=?, id_proof=? WHERE account_no=?");
            ps.setString(1, fullName);
            ps.setString(2, address);
            ps.setString(3, mobileNo);
            ps.setString(4, emailId);
            ps.setString(5, accountType);
            ps.setString(6, dob);
            ps.setString(7, idProof);
            ps.setString(8, accountNo);
            int result = ps.executeUpdate();

            out.println("<html><body>");
            if(result > 0) {
                out.println("<p>Account details updated successfully</p>");
            } else {
                out.println("<p>No customer found with account number: " + accountNo + "</p>");
            }
            out.println("</body></html>");
        } catch(Exception e) {
            e.printStackTrace(out);
        } finally {
            try { if(ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(out); }
            try { if(con != null) con.close(); } catch(Exception e) { e.printStackTrace(out); }
        }
    }
}
