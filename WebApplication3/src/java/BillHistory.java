
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class BillHistory extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int cid = Integer.parseInt(request.getParameter("CUSTID"));

        out.println("<html><head>");
        out.println("<script type=\"text/javascript\" src=\"aj.js\"></script>");
        out.println("</head><body>");
        

        try {
            Connection con = DBManager.getConnection();
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//
//            Connection con;
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from prevbills where id=?");

            ps.setInt(1, cid);

            ResultSet rs = ps.executeQuery();
            out.println("<h1>Customer Id: " + cid + "</h1>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Id</th><th>CustomerName</th><th>BillId</th><th>Price</th><th>Date</th></tr>");
            //int i=0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int bid = rs.getInt("bid");
                float price = rs.getFloat("amt");
                String date = rs.getString("date");
                

                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td><button id=\"b\" onclick=\"ajaxFunction(this)\">" + bid + "</button></td><td>" + price + "</td><td>" + date + "</td></tr>");
               // i++;
            }
            out.println("</table>");
            out.print("<div id=\"ajaxDiv\"></div>");

            out.println("</body></html>");

        } catch (SQLException se) {
            out.println(se);
        }

    }
}
