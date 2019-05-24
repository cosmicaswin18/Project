
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        //String name = request.getParameter("name");
        try {
            Connection con = DBManager.getConnection();
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//
//            Connection con;
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("delete from stock where id=?");

            ps.setInt(1, id);

            int i = ps.executeUpdate();

            if (i != 0) {
                out.println("Sucessfully Deleted Item");
                RequestDispatcher rd = request.getRequestDispatcher("stock.html");
                rd.include(request, response);

            }

        } catch (SQLException se) {
        }

    }
}
