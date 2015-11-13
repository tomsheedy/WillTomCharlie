/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author a2-painter
 */
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        LoginBean login = new LoginBean(name, password);
        request.setAttribute("LoginBean", login);
        
        out.println("<html>");
        out.println("<body>");
        out.println("Hello?");
        out.println("<>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
