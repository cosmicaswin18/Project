
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Edit extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // doPost(request,response);
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
//            Statement stmt = con.createStatement();
//            String query = "UPDATE stock SET id=id,iname=name,qty=qty,price=price WHERE id=" + id;

            PreparedStatement ps = con.prepareStatement("update stock set id=?,iname=?,qty=?,price=? where id=?");
//            out.println("sdfglkjhgjkjh");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, qty);
            ps.setFloat(4, pr);
            ps.setInt(5, id);
            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("Item sucessfully edited");
                RequestDispatcher rd = request.getRequestDispatcher("stock.html");
                rd.include(request, response);

            }

        } catch (SQLException se) {
        }

    }

}
