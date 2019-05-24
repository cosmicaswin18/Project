
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
    public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con=DriverManager.getConnection("jdbc:derby://localhost:1527/User", "root", "root");
		}catch(ClassNotFoundException | SQLException e){System.out.println(e);}
		return con;
	}
    
}
