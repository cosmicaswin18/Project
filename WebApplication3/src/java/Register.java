
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        int cid = 0;
        try {

            Connection con = DBManager.getConnection();

//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//
//            Connection con;
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into reg values(default,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            int i = ps.executeUpdate();
            PreparedStatement ps1 = con.prepareStatement("insert into Login values(?,?)");
            ps1.setString(1, name);
            ps1.setString(2, pass);

            PreparedStatement ps2 = con.prepareStatement("select * from reg where email=?");
            ps2.setString(1, email);

            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                cid = rs.getInt("id");
            }

            if (i > 0) {
                out.println("You are sucessfully registered<br>");
                out.println("You're Customer Id is " + cid);
                ps1.executeUpdate();
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }

        } catch (SQLException se) {
            out.print(se);
        }

    }
}
