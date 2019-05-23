
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate
 {
     public static boolean checkUser(String uname,String pass) 
     {
      boolean st =false;
      try{

         Class.forName("org.apache.derby.jdbc.ClientDriver");

         Connection con;
          con = DriverManager.getConnection("jdbc:derby://localhost:1527/User","root","root");
         PreparedStatement ps =con.prepareStatement("select * from Login where uname=? and pass=?");
         ps.setString(1, uname);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(ClassNotFoundException | SQLException e)
      {
      }
         return st;                 
  }   
}
