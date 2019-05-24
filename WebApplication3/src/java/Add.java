
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int qty = Integer.parseInt(request.getParameter("qty"));
        float pr = Float.valueOf(request.getParameter("price"));
        try {
            Connection con = DBManager.getConnection();
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            
//            Connection con;
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("insert into stock values(?,?,?,?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, qty);
            ps.setFloat(4, pr);
            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("Item sucessfully added");
                RequestDispatcher rd = request.getRequestDispatcher("stock.html");
                rd.include(request, response);

            }

        } catch (SQLException se) {
        }

    }
}
