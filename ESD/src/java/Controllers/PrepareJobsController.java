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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author t2-sheedy
 */
public class PrepareJobsController extends HttpServlet {

    public PrepareJobsController() {
        //super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = "a";//request.getParameter("name");
            String tester = "";
            List<Driver> results;
            Driver driv;
            HttpSession session = request.getSession();

            driv = new Driver();
            driv.setName(name);
            results = driv.List();
            
            for (Driver d : results) {                
                tester = tester + d.getPassword() + " // ";                
            }

            
            session.setAttribute("password", tester);

            response.sendRedirect("success.jsp");

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }

    }
}
