<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "org.apache.derby.jdbc.ClientDriver";
String connectionUrl = "jdbc:derby://localhost:1527/";
String database = "User";
String userid = "root";
String password = "root";
try {
Class.forName(driver);

} catch (ClassNotFoundException e) {
e.printStackTrace();
//out.print("haxn"+e);
}
Connection connection;
PreparedStatement statement;
ResultSet resultSet;
try{
int id=Integer.parseInt(request.getParameter("id"));
//int id = 200;
//String id = request.getParameter("id");
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
//Connection connection = DBManager.getConnection();
statement=connection.prepareStatement("select * from buy where billid=?");
//statement.setString(1, id);
statement.setInt(1, id);
//String sql ="select * from buy where billid=200";
resultSet = statement.executeQuery();
//out.print("zxcvbnm "+id);
int i=0;
while(resultSet.next()){
out.print(resultSet.getInt("prodid")+" "+resultSet.getString("billid")+" "+resultSet.getString("prodname")+" "+resultSet.getInt("prodqty")+" "+resultSet.getString("prodprice"));
out.print("<br>");
i++;
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
out.print("dfghj"+e);
}
%>