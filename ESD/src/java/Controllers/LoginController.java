/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.LoginResult;
import Models.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author a2-painter
 */
public class LoginController extends HttpServlet {

    public LoginController() {
        //super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authenticator auth;
        auth = new Authenticator();

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        LoginResult res = auth.Authenticate(name, password);
        String result = res.getLoginResult();
        String id = res.getLoggedInID();
        
        HttpSession session = request.getSession();

        if (result.contains("Fail") || "".equals(id)) {
            session.setAttribute("error", result);
            response.sendRedirect("error.jsp");
            
        } else {
            session.setAttribute("username", name);
            session.setAttribute("id", id);

            response.sendRedirect("success.jsp");
        }       
    }
}
