
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Buy extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int cid = Integer.parseInt(request.getParameter("CUSTID"));
        int bid = Integer.parseInt(request.getParameter("BILLID"));
        int pid = Integer.parseInt(request.getParameter("OPID"));
        int pqty = Integer.parseInt(request.getParameter("PQTY"));
        String pname = null;
        float price = 0, fp;
        int qty = 0, fq;
        try {

            Connection con = DBManager.getConnection();
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//
//            Connection con;
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from stock where id=?");

            ps.setInt(1, pid);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pname = rs.getString("iname");
                price = rs.getFloat("price");
                qty = rs.getInt("qty");

            }
            fp = (float) pqty * price;
            fq = qty - pqty;
            if (fq < 0) {
                out.print("Not Enough Stock");
                RequestDispatcher rd = request.getRequestDispatcher("buy.html");
                rd.include(request, response);
                return;
            }

            PreparedStatement ps1 = con.prepareStatement("insert into buy values(?,?,?,?,?,?)");
            ps1.setInt(1, cid);
            ps1.setInt(2, bid);
            ps1.setInt(3, pid);
            ps1.setString(4, pname);
            ps1.setInt(5, pqty);
            ps1.setFloat(6, fp);

            int i = ps1.executeUpdate();
            if (i > 0) {
                out.println("Item successfully bought");
//                ps1.executeUpdate();
//                RequestDispatcher rs = request.getRequestDispatcher("index.html");
//                rs.include(request, response);
            }

            PreparedStatement ps2 = con.prepareStatement("update stock set id=?,iname=?,qty=?,price=? where id=?");
//            out.println("sdfglkjhgjkjh");
            ps2.setInt(1, pid);
            ps2.setString(2, pname);
            ps2.setInt(3, fq);
            ps2.setFloat(4, price);
            ps2.setInt(5, pid);
            int j = ps2.executeUpdate();

            if (j > 0) {
                out.println("Database Updated Successfully");
                RequestDispatcher rd = request.getRequestDispatcher("buy.html");
                rd.include(request, response);
            }

        } catch (SQLException se) {
        }

    }
}
