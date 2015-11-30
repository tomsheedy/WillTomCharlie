/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.LoginResult;
import Models.Driver;
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
        
        String registration = request.getParameter("username");
        String password = request.getParameter("password");
        
        Driver driv;
        driv = new Driver();
        driv.setRegistration(registration);
        driv.setPassword(password);
               
        HttpSession session = request.getSession();
        
        session.setMaxInactiveInterval(20*60); //20 lots of 60 seconds = 20 minutes

        if (driv.LogIn()) {
                                
            Driver driverDetails = new Driver(registration);
            session.setAttribute("id", registration);
            session.setAttribute("name", driverDetails.getName());
            response.sendRedirect("admin.jsp");
            
        } else {
            
            session.setAttribute("error", "Log In Failed");
            response.sendRedirect("error.jsp");
            
        }   
        
        
        
        
        
        
        
        
        
        
        
        /*
        Authenticator auth;
        auth = new Authenticator();

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        LoginResult res = auth.Authenticate(name, password);
        String result = res.getLoginResult();
        String id = res.getLoggedInID();
        
        HttpSession session = request.getSession();
        
        session.setMaxInactiveInterval(20*60); //20 lots of 60 seconds = 20 minutes

        if (result.contains("Fail") || "".equals(id)) {
            session.setAttribute("error", result);
            response.sendRedirect("error.jsp");
            
        } else {
            session.setAttribute("username", name);
            session.setAttribute("id", id);

            response.sendRedirect("admin.jsp");
        }   
                */
    }
}
