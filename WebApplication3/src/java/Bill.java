
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Bill extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int cid = Integer.parseInt(request.getParameter("CUSTID"));
        String name = request.getParameter("CUSTNAME");

        float fp = 0;

        out.println("<html><body>");

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from buy where custid=?");

            ps.setInt(1, cid);

            ResultSet rs = ps.executeQuery();
            out.println("<h1>Customer Id: " + cid + "&nbsp;&nbsp;&nbsp;&nbsp;Customer Name: " + name + "</h1>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Id</th><th>ProductName</th><th>Quantity</th><th>Price</th></tr>");
            while (rs.next()) {
                int id = rs.getInt("prodid");
                String pname = rs.getString("prodname");
                int qty = rs.getInt("prodqty");
                float pprice = rs.getFloat("prodprice");
                fp += pprice;
                out.println("<tr><td>" + id + "</td><td>" + pname + "</td><td>" + qty + "</td><td>" + pprice + "</td></tr>");
            }
            out.println("</table>");
            out.println("<h2>Total Amount: Rs." + fp + "</h2>");

            out.println("</html></body>");

        } catch (ClassNotFoundException | SQLException se) {
        }

    }
}
