
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Display extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from stock");

//            ps.setInt(1, id);
//            ps.setString(2, name);
//            ps.setInt(3, qty);
//            ps.setFloat(4, pr);
            ResultSet rs = ps.executeQuery();
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>StockId</th><th>StockName</th><th>Quantity</th><th>Price</th></tr>");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                float price = rs.getFloat(4);
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + qty + "</td><td>" + price + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");

        } catch (ClassNotFoundException | SQLException se) {
        }

    }
}
