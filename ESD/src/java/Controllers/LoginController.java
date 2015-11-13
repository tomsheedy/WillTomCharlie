/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    
    public LoginController(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        response.setContentType("text/html;charset=UTF-8");

        /**To do
         * authenticate with database and check what type user is?
         * assuming login is success for now
        */
        
        rd = request.getRequestDispatcher("/jsp/success.jsp");
        User login = new User(name, password);
        request.setAttribute("user", login);
        rd.forward(request, response);
    }
}
