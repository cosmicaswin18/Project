package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class billdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
