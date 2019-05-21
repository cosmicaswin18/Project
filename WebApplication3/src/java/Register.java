import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        try{
        
        //loading drivers for mysql
        Class.forName("org.apache.derby.jdbc.ClientDriver");

	//creating connection with the database 
          Connection  con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/User","root","root");

        PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?)");

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, pass);
        int i=ps.executeUpdate();
        PreparedStatement ps1=con.prepareStatement("insert into Login values(?,?)");
        ps1.setString(1, email);
        ps1.setString(2, pass);

        
          if(i>0)
          {
            out.println("You are sucessfully registered");
            ps1.executeUpdate();
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
          }
        
        }
        catch(ClassNotFoundException | SQLException se)
        {
        }
	
      }
  }