
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Details extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int cid = Integer.parseInt(request.getParameter("CUSTID"));
        out.println("<html><body>");

        try {

//            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con = DBManager.getConnection();
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from reg where id = ?");
            ps.setInt(1, cid);

            ResultSet rs = ps.executeQuery();
            out.println("<table>");
            // out.println("<tr><th>Contents</th><th>Details</th></tr>");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String pass = rs.getString(4);
                out.println("<tr><td> Id </td><td>" + id + "</td></tr>");
                out.println("<tr><td> Name </td><td>" + name + "</td></tr>");
                out.println("<tr><td> Email </td><td>" + email + "</td></tr>");
                out.println("<tr><td> Password </td><td>" + pass + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");

        } catch (SQLException se) {
        }

    }
}
