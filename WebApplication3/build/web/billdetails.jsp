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
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
try{
int id=Integer.parseInt(request.getParameter("id"));
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
//Connection connection = DBManager.getConnection();
statement=connection.createStatement();
String sql ="select * from buy where billid="+id;
resultSet = statement.executeQuery(sql);
int i=0;
while(resultSet.next()){
out.print(resultSet.getInt("prodid")+" "+resultSet.getString("billid")+" "+resultSet.getString("prodname")+" "+resultSet.getInt("prodqty")+" "+resultSet.getString("prodprice"));
i++;
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>