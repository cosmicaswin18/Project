
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;

public class Bill extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int cid = Integer.parseInt(request.getParameter("CUSTID"));
//        String name = request.getParameter("CUSTNAME");
        int bid = Integer.parseInt(request.getParameter("BILLID"));
        String cname = null;

        float fp = 0;

        out.println("<html><body>");

        try {
            Connection con = DBManager.getConnection();
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            
//            Connection con;
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from buy where custid=? and billid=?");

            ps.setInt(1, cid);
            ps.setInt(2, bid);

            ResultSet rs = ps.executeQuery();
            out.println("<h1>Customer Id: " + cid + "</h1>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Id</th><th>BillId</th><th>ProductName</th><th>Quantity</th><th>Price</th></tr>");
            while (rs.next()) {
//                cname = rs.getString("custname");
                int id = rs.getInt("prodid");
                int billid = rs.getInt("billid");
                String pname = rs.getString("prodname");
                int qty = rs.getInt("prodqty");
                float pprice = rs.getFloat("prodprice");
                fp += pprice;
                out.println("<tr><td>" + id + "</td><td>" + billid + "</td><td>" + pname + "</td><td>" + qty + "</td><td>" + pprice + "</td></tr>");
            }
            out.println("</table>");
            out.println("<h2>Total Amount: Rs." + fp + "</h2>");

            out.println("</html></body>");

            Date date = new Date();
            String d = date.toString();

            PreparedStatement ps1 = con.prepareStatement("select * from reg where id=?");
            ps1.setInt(1, cid);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                cname = rs1.getString(2);

            }
            //String c = cname;

            PreparedStatement ps2 = con.prepareStatement("insert into prevbills values(?,?,?,?,?)");
            ps2.setInt(1, cid);
            ps2.setString(2, cname);
            ps2.setInt(3, bid);
            ps2.setFloat(4, fp);
            ps2.setString(5, d);
            int i = ps2.executeUpdate();

//            PreparedStatement ps3 = con.prepareStatement("delete from buy where custid = ?");
//            ps3.setInt(1, cid);
//            ps3.executeUpdate();
        } catch (SQLException se) {
            out.println(se);
        }

    }
}
