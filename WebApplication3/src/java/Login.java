
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("uname");
        String pass = request.getParameter("pass");

        if (Validate.checkUser(name, pass)) {
            out.println("Welcome " + name);
            RequestDispatcher rs = request.getRequestDispatcher("stock.html");
            rs.include(request, response);

        } else {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }
    }
}
